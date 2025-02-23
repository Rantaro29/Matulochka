package com.example.matulohka.utils

import androidx.core.util.PatternsCompat
import io.github.jan.supabase.auth.admin.AdminUserBuilder

object EmailPasswordValidator {

    fun emailValidate(email: String) : Boolean {
        return email.isNotEmpty() && PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun passwordValidate(password: String) : Boolean {
        val length = password.length > 7
        val hasLowerCase = password.any { it.isLowerCase() }
        val hasUpCase = password.any { it.isUpperCase() }
        val hasWhiteSpace = password.any { it.isWhitespace() }
        val hasDigit = password.any { it.isDigit() }
        val hasSpecialChar = password.any { it in "!@#$%^&*()_-+=№;:?*<>,./|'[]{}" }

        return length && hasLowerCase && hasUpCase && !hasWhiteSpace && hasDigit && hasSpecialChar

    }
}