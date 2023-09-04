package com.example.preferences_extension.Extensions

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

fun String.saveDataWithConfig(config: List<Any>, key: String){
    var context: Context? = null
    var table: String? = null
    var mode: Int? = null
    Log.d("gp", "Данные сохранены")

    config.forEach {
        when (it) {
            is Context -> {
                context = it
                Log.d("gp", context.toString())
            }

            is String -> {
                table = it
                Log.d("gp", table!!)
            }

            is Int -> {
                mode = it

            }

            else -> {
                // Логика обработки других типов данных
            }
        }
    }
    val sharedPreferences: SharedPreferences =
        context!!.getSharedPreferences(table, mode!!)
    val editor = sharedPreferences.edit()
    editor.putString(key, this)
    editor.apply()
}