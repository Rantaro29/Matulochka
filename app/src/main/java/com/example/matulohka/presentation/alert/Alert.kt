package com.example.matulohka.presentation.alert

import android.app.AlertDialog
import android.content.Context
import co.touchlab.kermit.Message

object Alert {
    fun defaultAlert(context: Context?, title: String = "Error", message: String = "Error") {
        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Ok") {_, _, ->}
            .create().show()
    }
}