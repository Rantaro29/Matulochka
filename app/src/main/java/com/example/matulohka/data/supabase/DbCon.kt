package com.example.matulohka.data.supabase

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object DbCon {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://vqxhhovnurpspfbpyhdn.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZxeGhob3ZudXJwc3BmYnB5aGRuIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzQwNzY1NzUsImV4cCI6MjA0OTY1MjU3NX0.QQC49D8LRLTEckr4kpmwwY9IrAR-FAMJpSfpquvK_XM"
    ) {
        install(Auth)
        install(Postgrest)
        //install other modules
    }

}