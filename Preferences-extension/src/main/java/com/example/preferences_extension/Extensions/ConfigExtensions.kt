package com.example.preferences_extension.Extensions

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.Log


@SuppressLint("ApplySharedPref")
private fun <T>configPreferencesFactory(
    config: List<Any>,
    key: String,
    isSave: Boolean,
    data: T
): Any {
    Log.d("gp", config.toString())
    var context: Context? = null
    var preference: String? = null
    var mode: Int? = null
    var isAsync: Boolean? = null
    var getData: Any = ""
    var a = 0

    config.forEach {
        Log.d("gp", config.size.toString())
        when (it) {
            is String -> preference = it
            is Int -> mode = it
            is Context -> context = it
            is Boolean -> isAsync = it
            else -> throw TypeCastException("The function does not accept the given type")
        }
    }

        val sharedPreferences: SharedPreferences =
            context!!.getSharedPreferences(preference, mode!!)

        Log.d("gp", preference.toString())



        if (isSave) {
            when (data) {
                is String -> {
                    if (!isAsync!!) {
                        sharedPreferences
                            .edit()
                            .putString(key, data)
                            .commit()
                    } else {
                        sharedPreferences
                            .edit()
                            .putString(key, data)
                            .apply()
                    }
                }

                is Int -> {
                    if (!isAsync!!) {
                        sharedPreferences
                            .edit()
                            .putInt(key, data)
                            .commit()
                    } else {
                        sharedPreferences
                            .edit()
                            .putInt(key, data)
                            .apply()
                    }
                }

                is Boolean -> {
                    if (!isAsync!!) {
                        sharedPreferences
                            .edit()
                            .putBoolean(key, data)
                            .commit()
                    } else {
                        sharedPreferences
                            .edit()
                            .putBoolean(key, data)
                            .apply()
                    }
                }

                is Float -> {
                    if (!isAsync!!) {
                        sharedPreferences
                            .edit()
                            .putFloat(key, data)
                            .commit()
                    } else {
                        sharedPreferences
                            .edit()
                            .putFloat(key, data)
                            .apply()
                    }
                }

                is Long -> {
                    if (!isAsync!!) {
                        sharedPreferences
                            .edit()
                            .putLong(key, data)
                            .commit()
                    } else {
                        sharedPreferences
                            .edit()
                            .putLong(key, data)
                            .apply()
                    }
                }

                is Set<*> -> {
                    if (!isAsync!!) {
                        val setDataSave = data.map { it.toString() }.toSet()
                        sharedPreferences
                            .edit()
                            .putStringSet(key, setDataSave)
                            .commit()
                    } else {
                        val setDataSave = data.map { it.toString() }.toSet()
                        sharedPreferences
                            .edit()
                            .putStringSet(key, setDataSave)
                            .apply()
                    }

                }

                is List<*> -> {
                    if (!isAsync!!) {
                        val listDataSave = data.map { it.toString() }.toSet()
                        sharedPreferences
                            .edit()
                            .putStringSet(key, listDataSave)
                            .commit()
                    } else {
                        val listDataSave = data.map { it.toString() }.toSet()
                        sharedPreferences
                            .edit()
                            .putStringSet(key, listDataSave)
                            .apply()
                    }
                }
            }
        } else {

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
                        when (data.first()) {
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
                    } catch (e: Exception) {
                        Log.e(
                            "preferences-extension",
                            "There are no elements in your collection, the library cannot determine the data type, add an element with the desired data type and a random value"
                        )
                    }
                    if (setData!!.isEmpty())
                        Log.e("preferences-extension", "Maybe this key does not exist")

                }

                is List<*> -> {
                    val listData = sharedPreferences
                        .getStringSet(key, setOf())
                    try {
                        when (data.first()) {
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
                    } catch (e: Exception) {
                        Log.e(
                            "preferences-extension",
                            "There are no elements in your collection, the library cannot determine the data type, add an element with the desired data type and a random value"
                        )
                    }

                    if (listData!!.isEmpty())
                        Log.e("preferences-extension", "Maybe this key does not exist")

                }
            }

        }


    return getData
}












fun String.saveDataWithConfig(config: List<Any>, key: String){
    configPreferencesFactory(
        config,
        key,
        true,
        this
    )

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
// Get data functions.
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
    val data = sharedPreferences.getString(key, "")
    return data?:""
}

fun Int.getDataWithConfig(config: List<Any>, key:String): Int{
    var context: Context? = null
    var table: String? = null
    var mode: Int? = null
    var isAsync:Boolean? = null
    config.forEach{
        when(it) {
            is Context -> context = it
            is String -> table = it
            is Int -> mode = it
            is Boolean -> isAsync = it
            else -> throw TypeCastException("The function does not accept the given type")
        }
    }
    val sharedPreferences: SharedPreferences =
        context!!.getSharedPreferences(table, mode!!)
    val data = sharedPreferences.getInt(key, 0)
    return data
}

fun Float.getDataWithConfig(config: List<Any>, key:String): Float{
    var context: Context? = null
    var table: String? = null
    var mode: Int? = null
    var isAsync:Boolean? = null
    config.forEach{
        when(it) {
            is Context -> context = it
            is String -> table = it
            is Int -> mode = it
            is Boolean -> isAsync = it
            else -> throw TypeCastException("The function does not accept the given type")
        }
    }
    val sharedPreferences: SharedPreferences =
        context!!.getSharedPreferences(table, mode!!)
    val data = sharedPreferences.getFloat(key, 0.0f)
    return data
}