package com.example.preferences_extension.Extensions

import android.content.Context
import android.content.SharedPreferences

private fun asyncPreferenceFactory(
    key: String,
    preference: String,
    context: Context,
    isSave: Boolean
): Any {
    when (isSave) {
        true -> {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences(preference, Context.MODE_PRIVATE)
            return sharedPreferences.edit()
        }

        false -> {
            return context.getSharedPreferences(preference, Context.MODE_PRIVATE)
        }
    }
}