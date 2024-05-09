package com.example.preferences_extension.Extensions

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.Log


/**
 * This file contains extension functions for saving and getting data.
 * **/

/**
 * Save data functions
 * **/

@SuppressLint("ApplySharedPref")
private fun <T>preferencesFactory(
    context: Context,
    preference: String,
    isSave: Boolean,
    data: T,
    key: String
): Any {
    when (isSave) {
        true -> {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences(preference, Context.MODE_PRIVATE)

            when (data) {
                is String -> {
                    sharedPreferences
                        .edit()
                        .putString(key, data)
                        .commit()
                }
                is Int -> {
                    sharedPreferences
                        .edit()
                        .putInt(key, data)
                        .commit()
                }
                is Boolean -> {
                    sharedPreferences
                        .edit()
                        .putBoolean(key, data)
                        .commit()
                }
                is Float -> {
                    sharedPreferences
                        .edit()
                        .putFloat(key, data)
                        .commit()
                }
                is Long -> {
                    sharedPreferences
                        .edit()
                        .putLong(key, data)
                        .commit()
                }
                is Set<*> -> {
                    sharedPreferences
                        .edit()
                        .putStringSet(key, data as Set<String>)
                        .commit()
                }
                is List<*> -> {
                    sharedPreferences
                        .edit()
                        .putStringSet(key, data as Set<String>)
                        .commit()
                }
            }

            return sharedPreferences.edit()
        }
        false -> {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences(preference, Context.MODE_PRIVATE)
            var getData: Any = ""
            when (data) {
                is String -> {
                    val stringData = sharedPreferences
                        .getString(key, null)
                    if (stringData == null)
                        Log.e("preferences-extension", "This key does not exist")
                    getData = stringData!!
                }
                is Int -> {
                    val intData = sharedPreferences
                        .getInt(key, 0)
                    if (intData == 0)
                        Log.e("preferences-extension", "Maybe this key does not exist")
                    getData = intData
                }
                is Boolean -> {
                    val booleanData = sharedPreferences
                        .getBoolean(key, false)
                    if (!booleanData)
                        Log.e("preferences-extension", "Maybe this key does not exist")
                    getData = booleanData
                }
                is Float -> {
                    val floatData = sharedPreferences
                        .getFloat(key, 0.0f)
                    if (floatData == 0.0f)
                        Log.e("preferences-extension", "Maybe this key does not exist")
                    getData = floatData
                }
                is Long -> {
                    val longData = sharedPreferences
                        .getLong(key, 0)
                    if (longData == 0L)
                        Log.e("preferences-extension", "Maybe this key does not exist")
                    getData = longData
                }
                is Set<*> -> {
                    val setData = sharedPreferences
                        .getStringSet(key, setOf())
                    if (setData!!.isEmpty())
                        Log.e("preferences-extension", "Maybe this key does not exist")
                    getData = setData
                }
                is List<*> -> {
                    val listData = sharedPreferences
                        .getStringSet(key, setOf())
                    if (listData!!.isEmpty())
                        Log.e("preferences-extension", "Maybe this key does not exist")
                    getData = listData
                }
            }
            return getData
        }
    }
}



fun String.saveData(
    key: String,
    preference: String,
    context: Context
){
    preferencesFactory(
        context = context,
        preference = preference,
        isSave = true,
        data = this,
        key = key
    )

}

fun Int.saveData(
    key: String,
    preference: String,
    context: Context
){
    preferencesFactory(
        context = context,
        preference = preference,
        isSave = true,
        data = this,
        key = key
    )
}

fun Float.saveData(
    key: String,
    preference: String,
    context: Context
) {
    preferencesFactory(
        context = context,
        preference = preference,
        isSave = true,
        data = this,
        key = key
    )
}

fun Boolean.saveData(
    key: String,
    preference: String,
    context: Context
){
    preferencesFactory(
        context = context,
        preference = preference,
        isSave = true,
        data = this,
        key = key
    )
}

fun Long.saveData(
    key: String,
    preference: String,
    context: Context
){
    preferencesFactory(
        context = context,
        preference = preference,
        isSave = true,
        data = this,
        key = key
    )
}

fun Set<String>.saveData(
    key: String,
    preference: String,
    context: Context
){
    preferencesFactory(
        context = context,
        preference = preference,
        isSave = true,
        data = this,
        key = key
    )
}

fun List<String>.saveData(
    key: String,
    preference: String,
    context: Context
){
    preferencesFactory(
        context = context,
        preference = preference,
        isSave = true,
        data = this,
        key = key
    )
}



/**
 * Get data functions
 * **/

// ОНИ НЕ РАБОТАЮТ ПОТОМ ДОДЕЛАТЬ НАДО

fun String.getData(
    key: String,
    preference: String,
    context: Context
): String{

    return preferencesFactory(
        context = context,
        preference = preference,
        isSave = false,
        data = this,
        key = key
    ) as String
}

fun Int.getData(
    key: String,
    preference: String,
    context: Context
): Int{

    preferencesFactory(
        context = context,
        preference = preference,
        isSave = true,
        data = this,
        key = key
    )
    return 0
}

fun Float.getData(
    key: String,
    preference: String,
    context: Context
): Float{

    preferencesFactory(
        context = context,
        preference = preference,
        isSave = true,
        data = this,
        key = key
    )
    return 0.0f
}

fun Boolean.getData(
    key: String,
    preference: String,
    context: Context
): Boolean {

    preferencesFactory(
        context = context,
        preference = preference,
        isSave = true,
        data = this,
        key = key
    )
    return false
}

fun Long.getData(
    key: String,
    preference: String,
    context: Context
): Long{

    preferencesFactory(
        context = context,
        preference = preference,
        isSave = true,
        data = this,
        key = key
    )
    return 1
}

fun Set<String>.getData(
    key: String,
    preference: String,
    context: Context
): Set<String>{

    preferencesFactory(
        context = context,
        preference = preference,
        isSave = true,
        data = this,
        key = key
    )
    return "" as Set<String>
}