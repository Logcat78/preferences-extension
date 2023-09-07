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
            else -> throw TypeCastException("The function does not accept the given type")
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

fun Int.saveDataWithConfig(config: List<Any>, key: String){
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
            else -> throw TypeCastException("The function does not accept the given type")
        }
    }
    val sharedPreferences: SharedPreferences =
        context!!.getSharedPreferences(table, mode!!)
    val editor = sharedPreferences.edit()
    editor.putInt(key, this)

    if(isAsync!!){
        editor.apply()
    }else{
        editor.commit()
    }

}

fun Float.saveDataWithConfig(config: List<Any>, key: String){
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
            else -> throw TypeCastException("The function does not accept the given type")
        }
    }
    val sharedPreferences: SharedPreferences =
        context!!.getSharedPreferences(table, mode!!)
    val editor = sharedPreferences.edit()
    editor.putFloat(key, this)

    if(isAsync!!){
        editor.apply()
    }else{
        editor.commit()
    }

}

fun Boolean.saveDataWithConfig(config: List<Any>, key: String){
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
            else -> throw TypeCastException("The function does not accept the given type")
        }
    }
    val sharedPreferences: SharedPreferences =
        context!!.getSharedPreferences(table, mode!!)
    val editor = sharedPreferences.edit()
    editor.putBoolean(key, this)

    if(isAsync!!){
        editor.apply()
    }else{
        editor.commit()
    }

}

fun Long.saveDataWithConfig(config: List<Any>, key: String){
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
            else -> throw TypeCastException("The function does not accept the given type")
        }
    }
    val sharedPreferences: SharedPreferences =
        context!!.getSharedPreferences(table, mode!!)
    val editor = sharedPreferences.edit()
    editor.putLong(key, this)

    if(isAsync!!){
        editor.apply()
    }else{
        editor.commit()
    }

}

fun Set<String>.saveDataWithConfig(config: List<Any>, key: String){
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
            else -> throw TypeCastException("The function does not accept the given type")
        }
    }
    val sharedPreferences: SharedPreferences =
        context!!.getSharedPreferences(table, mode!!)
    val editor = sharedPreferences.edit()
    editor.putStringSet(key, this)

    if(isAsync!!){
        editor.apply()
    }else{
        editor.commit()
    }

}
// Get data functions
fun String.getDataWithConfig(config: List<Any>, key: String): String{
    var context: Context? = null
    var table: String? = null
    var mode: Int? = null
    var isAsync:Boolean? = null

    config.forEach {
        when (it) {
            is Context -> context = it
            is String -> table = it
            is Int -> mode = it
            is Boolean -> isAsync = it
            else -> throw TypeCastException("The function does not accept the given type")
        }
    }
    val sharedPreferences: SharedPreferences =
        context!!.getSharedPreferences(table, mode!!)
    val editor = sharedPreferences.edit()
    val data = sharedPreferences.getString(key, "")
    return data?:""
}