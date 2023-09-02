package com.example.preferences_extension

import android.content.Context
import android.content.SharedPreferences

/**
 * This file contains extension functions for saving and getting data.
 *
 * **/

fun String.save(
    key: String,
    context: Context,
    table: String){
    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(table, Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString(key, this)
    editor.apply()
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