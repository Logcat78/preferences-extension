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
    key: String,
    isAsync: Boolean
): Any {
    when (isSave) {
        true -> {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences(preference, Context.MODE_PRIVATE)

            when (data) {
                is String -> {
                    if (!isAsync) {
                        sharedPreferences
                            .edit()
                            .putString(key, data)
                            .commit()
                    }else{
                        sharedPreferences
                            .edit()
                            .putString(key, data)
                            .apply()
                    }
                }
                is Int -> {
                    if (!isAsync) {
                        sharedPreferences
                            .edit()
                            .putInt(key, data)
                            .commit()
                    }else{
                        sharedPreferences
                            .edit()
                            .putInt(key, data)
                            .apply()
                    }
                }
                is Boolean -> {
                    if (!isAsync) {
                        sharedPreferences
                            .edit()
                            .putBoolean(key, data)
                            .commit()
                    }else{
                        sharedPreferences
                            .edit()
                            .putBoolean(key, data)
                            .apply()
                    }
                }
                is Float -> {
                    if (!isAsync) {
                        sharedPreferences
                            .edit()
                            .putFloat(key, data)
                            .commit()
                    }else{
                        sharedPreferences
                            .edit()
                            .putFloat(key, data)
                            .apply()
                    }
                }
                is Long -> {
                    if (!isAsync) {
                        sharedPreferences
                            .edit()
                            .putLong(key, data)
                            .commit()
                    }else{
                        sharedPreferences
                            .edit()
                            .putLong(key, data)
                            .apply()
                    }
                }
                is Set<*> -> {
                    if (!isAsync) {
                        val setDataSave = data.map { it.toString()}.toSet()
                        sharedPreferences
                            .edit()
                            .putStringSet(key, setDataSave)
                            .commit()
                    }else{
                        val setDataSave = data.map { it.toString()}.toSet()
                        sharedPreferences
                            .edit()
                            .putStringSet(key, setDataSave)
                            .apply()
                    }

                }
                is List<*> -> {
                    if(!isAsync) {
                        val listDataSave = data.map { it.toString() }.toSet()
                        sharedPreferences
                            .edit()
                            .putStringSet(key, listDataSave)
                            .commit()
                    }else{
                        val listDataSave = data.map { it.toString() }.toSet()
                        sharedPreferences
                            .edit()
                            .putStringSet(key, listDataSave)
                            .apply()
                    }
                }

                is Short -> {
                    if (!isAsync) {
                        sharedPreferences
                            .edit()
                            .putInt(key, data.toInt())
                            .commit()
                    }else{
                        sharedPreferences
                            .edit()
                            .putInt(key, data.toInt())
                            .apply()
                    }
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

                is Short -> {
                    val shortData = sharedPreferences.getInt(key, 0)

                    if (shortData == 0) {
                        Log.e("preferences-extension", "Maybe this key does not exist")
                    }
                    getData = shortData.toShort()
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
        key = key,
        isAsync = false
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
        key = key,
        isAsync = false
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
        key = key,
        isAsync = false
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
        key = key,
        isAsync = false
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
        key = key,
        isAsync = false
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
        key = key,
        isAsync = false
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
        key = key,
        isAsync = false
    )
}

fun Short.saveData(
    key: String,
    preference: String,
    context: Context
){
    preferencesFactory(
        context = context,
        preference = preference,
        isSave = true,
        data = this,
        key = key,
        isAsync = false
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
        key = key,
        isAsync = false
    ) as String
}

fun Int.getData(
    key: String,
    preference: String,
    context: Context
): Int{

    return preferencesFactory(
        context = context,
        preference = preference,
        isSave = false,
        data = this,
        key = key,
        isAsync = false
    ) as Int
}

fun Float.getData(
    key: String,
    preference: String,
    context: Context
): Float{

    return preferencesFactory(
        context = context,
        preference = preference,
        isSave = false,
        data = this,
        key = key,
        isAsync = false
    ) as Float
}

fun Boolean.getData(
    key: String,
    preference: String,
    context: Context
): Boolean {

    return preferencesFactory(
        context = context,
        preference = preference,
        isSave = false,
        data = this,
        key = key,
        isAsync = false
    ) as Boolean
}

fun Long.getData(
    key: String,
    preference: String,
    context: Context
): Long{

    return preferencesFactory(
        context = context,
        preference = preference,
        isSave = false,
        data = this,
        key = key,
        isAsync = false
    ) as Long
}

fun Short.getData(
    key: String,
    preference: String,
    context: Context
): Short{

    return preferencesFactory(
        context = context,
        preference = preference,
        isSave = false,
        data = this,
        key = key,
        isAsync = false
    ) as Short
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
        key = key,
        isAsync = false
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
        key = key,
        isAsync = false
    ) as List<T>

}

fun String.asyncGetData(
    key: String,
    preference: String,
    context: Context
): String{

    return preferencesFactory(
        context = context,
        preference = preference,
        isSave = false,
        data = this,
        key = key,
        isAsync = true
    ) as String
}

fun Int.asyncGetData(
    key: String,
    preference: String,
    context: Context
): Int{

    return preferencesFactory(
        context = context,
        preference = preference,
        isSave = false,
        data = this,
        key = key,
        isAsync = true
    ) as Int
}

fun Float.asyncGetData(
    key: String,
    preference: String,
    context: Context
): Float{

    return preferencesFactory(
        context = context,
        preference = preference,
        isSave = false,
        data = this,
        key = key,
        isAsync = true
    ) as Float
}

fun Boolean.asyncGetData(
    key: String,
    preference: String,
    context: Context
): Boolean {

    return preferencesFactory(
        context = context,
        preference = preference,
        isSave = false,
        data = this,
        key = key,
        isAsync = true
    ) as Boolean
}

fun Long.asyncGetData(
    key: String,
    preference: String,
    context: Context
): Long{

    return preferencesFactory(
        context = context,
        preference = preference,
        isSave = false,
        data = this,
        key = key,
        isAsync = true
    ) as Long
}

fun Short.asyncGetData(
    key: String,
    preference: String,
    context: Context
): Short{

    return preferencesFactory(
        context = context,
        preference = preference,
        isSave = false,
        data = this,
        key = key,
        isAsync = true
    ) as Short
}

fun <T>Set<*>.asyncGetData(
    key: String,
    preference: String,
    context: Context
): Set<*>{

    return preferencesFactory(
        context = context,
        preference = preference,
        isSave = false,
        data = this,
        key = key,
        isAsync = true
    ) as Set<T>

}

fun <T>List<*>.asyncGetData(
    key: String,
    preference: String,
    context: Context
): List<*>{

    return preferencesFactory(
        context = context,
        preference = preference,
        isSave = false,
        data = this,
        key = key,
        isAsync = true
    ) as List<T>

}


