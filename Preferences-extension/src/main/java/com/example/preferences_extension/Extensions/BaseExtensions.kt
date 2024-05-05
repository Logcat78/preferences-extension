package com.example.preferences_extension.Extensions

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

/**
 * This file contains extension functions for saving and getting data.
 * **/

/**
 * Save data functions
 * **/

private fun preferencesFactory(
    context: Context,
    preference: String,
    isSave: Boolean,
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



fun String.save(
    key: String,
    context: Context,
    table: String){
    val editor = preferencesFactory(context, table, true) as SharedPreferences.Editor
    editor.putString(key, this)
    Log.d("gp", this + " сохранил")
    editor.commit()
}

fun Int.save(
    key: String,
    context: Context,
    table: String){
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(table, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putInt(key, this)
    editor.apply()
}

fun Float.save(
    key: String,
    context: Context,
    table: String){
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(table, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putFloat(key, this)
    editor.apply()
}

fun Boolean.save(
    key: String,
    context: Context,
    table: String){
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(table, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean(key, this)
    editor.apply()
}

fun Long.save(
    key: String,
    context: Context,
    table: String){
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(table, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putLong(key, this)
    editor.apply()
}

fun Set<String>.save(
    key: String,
    context: Context,
    table: String){
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(table, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putStringSet(key, this)
    editor.apply()
}

fun List<String>.saveData(
    key: String,
    context: Context,
    table: String){
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(table, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putStringSet(key, this.toSet())
    editor.apply()
}



/**
 * Get data functions
 * **/

fun String.getData(
    key: String,
    context: Context,
    table: String): String{
    val sharedPreferences = preferencesFactory(context, table, false) as SharedPreferences
    val data = sharedPreferences.getString(key, "")
    return data!!
}

fun Int.getData(
    key: String,
    context: Context,
    table: String): Int{
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(table, Context.MODE_PRIVATE)
    val data = sharedPreferences.getInt(key, 0)
    return data
}

fun Float.getData(
    key: String,
    context: Context,
    table: String): Float{
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(table, Context.MODE_PRIVATE)
    val data = sharedPreferences.getFloat(key, 0.0f)
    return data
}

fun Boolean.getData(
    key: String,
    context: Context,
    table: String): Boolean{
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(table, Context.MODE_PRIVATE)
    val data = sharedPreferences.getBoolean(key, false)
    return data
}

fun Long.getData(
    key: String,
    context: Context,
    table: String): Long{
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(table, Context.MODE_PRIVATE)
    val data = sharedPreferences.getLong(key, 0)
    return data
}

fun Set<String>.getData(
    key: String,
    context: Context,
    table: String): Set<String>{
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(table, Context.MODE_PRIVATE)
    val data = sharedPreferences.getStringSet(key, setOf())
    return data?: setOf()
}



