package com.example.preferences_extension.Extensions

import android.content.Context
import android.content.SharedPreferences


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



fun String.saveData(
    key: String,
    preference: String,
    context: Context
){
    val editor = preferencesFactory(
        context = context,
        preference = preference,
        isSave = true
    ) as SharedPreferences.Editor

    editor
        .putString(key, this)
    editor.commit()
}

fun Int.saveData(
    key: String,
    preference: String,
    context: Context
){
    val editor = preferencesFactory(
        context = context,
        preference = preference,
        isSave = true
    ) as SharedPreferences.Editor

    editor.putInt(key, this)
    editor.commit()
}

fun Float.saveData(
    key: String,
    preference: String,
    context: Context
){
    val editor = preferencesFactory(
        context = context,
        preference = preference,
        isSave = true
    ) as SharedPreferences.Editor

    editor.putFloat(key, this)
    editor.commit()
}

fun Boolean.saveData(
    key: String,
    preference: String,
    context: Context
){
    val editor = preferencesFactory(
        context = context,
        preference = preference,
        isSave = true
    ) as SharedPreferences.Editor

    editor.putBoolean(key, this)
    editor.commit()
}

fun Long.saveData(
    key: String,
    preference: String,
    context: Context
){
    val editor = preferencesFactory(
        context = context,
        preference = preference,
        isSave = true
    ) as SharedPreferences.Editor

    editor.putLong(key, this)
    editor.commit()
}

fun Set<String>.saveData(
    key: String,
    preference: String,
    context: Context
){
    val editor = preferencesFactory(
        context = context,
        preference = preference,
        isSave = true
    ) as SharedPreferences.Editor

    editor.putStringSet(key, this)
    editor.commit()
}

fun List<String>.saveData(
    key: String,
    preference: String,
    context: Context
){
    val editor = preferencesFactory(
        context = context,
        preference = preference,
        isSave = true
    ) as SharedPreferences.Editor

    editor.putStringSet(key, this.toSet())
    editor.commit()
}



/**
 * Get data functions
 * **/



fun String.getData(
    key: String,
    preference: String,
    context: Context
): String{

    val sharedPreferences = preferencesFactory(
        context = context,
        preference = preference,
        isSave = false
    ) as SharedPreferences
    return sharedPreferences
        .getString(
            key,
            "This key does not exist"
        )!!
}

fun Int.getData(
    key: String,
    preference: String,
    context: Context
): Int{

    val sharedPreferences = preferencesFactory(
        context = context,
        preference = preference,
        isSave = false
    ) as SharedPreferences

    return sharedPreferences
        .getInt(
            key,
            0
        )
}

fun Float.getData(
    key: String,
    preference: String,
    context: Context
): Float{

    val sharedPreferences = preferencesFactory(
        context = context,
        preference = preference,
        isSave = false
    ) as SharedPreferences

    return sharedPreferences
        .getFloat(
            key,
            0.0f
        )
}

fun Boolean.getData(
    key: String,
    preference: String,
    context: Context
): Boolean{

    val sharedPreferences = preferencesFactory(
        context = context,
        preference = preference,
        isSave = false
    ) as SharedPreferences

    return sharedPreferences
        .getBoolean(key, false)
}

fun Long.getData(
    key: String,
    preference: String,
    context: Context
): Long{

    val sharedPreferences = preferencesFactory(
        context = context,
        preference = preference,
        isSave = false
    ) as SharedPreferences

    return sharedPreferences
        .getLong(key, 0)
}

fun Set<String>.getData(
    key: String,
    preference: String,
    context: Context
): Set<String>{

    val sharedPreferences = preferencesFactory(
        context = context,
        preference = preference,
        isSave = false
    ) as SharedPreferences

    return sharedPreferences
        .getStringSet(key, setOf())?: setOf()
}