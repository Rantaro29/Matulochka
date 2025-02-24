package com.example.matulohka.presentation.fragments

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.transition.Visibility
import com.example.matulohka.R
import com.example.matulohka.databinding.FragmentSingInBinding
import com.example.matulohka.presentation.alert.Alert
import com.example.matulohka.presentation.viewmodel.AuthViewModel
import com.example.matulohka.utils.EmailPasswordValidator
import io.github.jan.supabase.auth.exception.AuthRestException
import io.github.jan.supabase.auth.user.UserInfo
import io.github.jan.supabase.exceptions.HttpRequestException
import io.ktor.client.plugins.HttpRequestTimeoutException
import kotlinx.coroutines.launch

class SingInFragment : Fragment() {

    private lateinit var binding: FragmentSingInBinding
    private val authViewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSingInBinding.inflate(layoutInflater)

        binding.progressBar.visibility = View.INVISIBLE

        binding.checkbox.setOnCheckedChangeListener {_, check ->
            if(check) {
                binding.LogInPasswordEditText.transformationMethod = null
            } else {
                binding.LogInPasswordEditText.transformationMethod = PasswordTransformationMethod()
            }

            binding.LogInPasswordEditText.setSelection(binding.LogInPasswordEditText.length())
        }

        binding.singInButton.setOnClickListener {
            val email : String = binding.LogInEmailEditText.text.toString()
            val password: String = binding.LogInPasswordEditText.text.toString()

            if(!EmailPasswordValidator.emailValidate(email)){
                Alert.defaultAlert(context = context, message = "Invalid Email")
            } else if(!EmailPasswordValidator.passwordValidate(password)) {
                Alert.defaultAlert(context = context, message = "Invalid Password")
            } else {

                lifecycleScope.launch {
                    var userInfo: UserInfo? = null

                    try {
                        userInfo = authViewModel.singIn(email, password)

                        binding.progressBar.visibility = View.VISIBLE

                        if(userInfo != null) {
                            findNavController().navigate(R.id.action_singInFragment_to_homeFragment)
                        } else {
                            Alert.defaultAlert(context = context, message = "Invalid Login")
                        }
                    }
                    catch (e: HttpRequestTimeoutException) {
                        Alert.defaultAlert(context = context, message = "Превышено время ожидания")
                    } catch (e: AuthRestException) {
                        Alert.defaultAlert(context = context, message = "Invalid Login")
                    } catch (e: HttpRequestException) {
                        Alert.defaultAlert(context = context, message = "Нету подключения к интернету")
                    }

                }.invokeOnCompletion {
                    binding.progressBar.visibility = View.INVISIBLE
                }

            }
        }

        return binding.root
    }

}