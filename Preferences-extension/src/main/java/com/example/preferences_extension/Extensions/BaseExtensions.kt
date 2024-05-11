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
            Log.e("gp", "pop")

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
                    Log.e("gp", data.toString())
                    val setDataSave = data.map { it.toString()}.toSet()
                    sharedPreferences
                        .edit()
                        .putStringSet(key, setDataSave)
                        .commit()
                    Log.d("gp", sharedPreferences.getStringSet(key, setOf("popka")).toString())
                }
                is List<*> -> {
                    val listDataSave = data.map { it.toString() }.toSet()
                    sharedPreferences
                        .edit()
                        .putStringSet(key, listDataSave)
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
                    try {
                        when(data.first()){
                            is String -> {
                                getData = setData as Set<String>
                            }
                            is Int -> {
                                getData = setData!!.map { it.toInt() }.toSet<Int>()
                            }
                            is Boolean -> {
                                getData = setData!!.map { it.toBoolean() }.toSet()
                            }
                            is Float -> {
                                getData = setData!!.map { it.toFloat() }.toSet()
                            }
                            is Long -> {
                                getData = setData!!.map { it.toLong() }.toSet()
                            }
                            is Short -> {
                                getData = setData!!.map { it.toShort() }.toSet()
                            }

                            else -> {
                                Log.e("preferences-extension", "This data type is not supported")
                            }
                        }
                    }catch (e: Exception){
                        Log.e("preferences-extension", "There are no elements in your collection, the library cannot determine the data type, add an element with the desired data type and a random value")
                    }
                    if (setData!!.isEmpty())
                        Log.e("preferences-extension", "Maybe this key does not exist")

                }
                is List<*> -> {
                    val listData = sharedPreferences
                        .getStringSet(key, setOf())
                    try{
                        when(data.first()){
                            is String -> {
                                getData = listData as Set<String>
                            }
                            is Int -> {
                                getData = listData!!.map { it.toInt() }.toList()
                            }
                            is Boolean -> {
                                getData = listData!!.map { it.toBoolean() }.toList()
                            }
                            is Float -> {
                                getData = listData!!.map { it.toFloat() }.toList()
                            }
                            is Long -> {
                                getData = listData!!.map { it.toLong() }.toList()
                            }
                            is Short -> {
                                getData = listData!!.map { it.toShort() }.toList()
                            }

                            else -> {
                                Log.e("preferences-extension", "This data type is not supported")
                            }
                        }
                    }catch (e: Exception){
                        Log.e("preferences-extension", "There are no elements in your collection, the library cannot determine the data type, add an element with the desired data type and a random value")
                    }

                    if (listData!!.isEmpty())
                        Log.e("preferences-extension", "Maybe this key does not exist")

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

fun Set<*>.saveData(
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

fun List<*>.saveData(
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

fun <T>Set<*>.getData(
    key: String,
    preference: String,
    context: Context
): Set<*>{

    return preferencesFactory(
        context = context,
        preference = preference,
        isSave = false,
        data = this,
        key = key
    ) as Set<T>

}

fun <T>List<*>.getData(
    key: String,
    preference: String,
    context: Context
): List<*>{

    return preferencesFactory(
        context = context,
        preference = preference,
        isSave = false,
        data = this,
        key = key
    ) as List<T>

}