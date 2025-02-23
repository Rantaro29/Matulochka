package com.example.matulohka.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.matulohka.data.supabase.DbCon
import com.example.matulohka.domain.repository.AuthRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.user.UserInfo

class AuthViewModel : ViewModel() {

    private val _user: MutableLiveData<UserInfo> = MutableLiveData<UserInfo>()
    val user : LiveData<UserInfo> = _user

    suspend fun singIn(email: String, password: String) : UserInfo? {
        AuthRepository.singIn(email, password)

        _user.value = DbCon.supabase.auth.currentUserOrNull()

        return DbCon.supabase.auth.currentUserOrNull()
    }

}