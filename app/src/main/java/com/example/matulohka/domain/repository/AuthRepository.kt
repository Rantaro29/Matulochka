package com.example.matulohka.domain.repository

import com.example.matulohka.data.supabase.DbCon
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email

object AuthRepository {
    suspend fun singIn(out_email: String, out_password: String) {
        DbCon.supabase.auth.signInWith(Email) {
            email = out_email
            password = out_password
        }
    }
}