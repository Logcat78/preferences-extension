package com.example.preferences_extension.Extensions

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

fun String.saveDataWithConfig(config: List<Any>, key: String){
    var context: Context? = null
    var table: String? = null
    var mode: Int? = null
    var isAsync:Boolean? = null
    Log.d("gp", "Данные сохранены")

    config.forEach {
        when (it) {
            is Context -> context = it
            is String -> table = it
            is Int -> mode = it
            is Boolean -> isAsync = it



            else -> {
                // Тут надо релизовать ошибку
            }
        }
    }
    val sharedPreferences: SharedPreferences =
        context!!.getSharedPreferences(table, mode!!)
    val editor = sharedPreferences.edit()
    editor.putString(key, this)

    if(isAsync!!){
        editor.apply()
    }else{
        editor.commit()
    }

}