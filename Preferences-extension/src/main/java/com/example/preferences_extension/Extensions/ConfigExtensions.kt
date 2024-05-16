package com.example.preferences_extension.Extensions

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
/**
 * This file contains extensions for saving data using a configuration list**/
/**
 * Save data functions
 * **/


@SuppressLint("ApplySharedPref")
private fun <T>configPreferencesFactory(
    config: List<Any>,
    key: String,
    data: T
) {
    var context: Context? = null
    var preference: String? = null
    var mode: Int? = null
    var isAsync: Boolean? = null

    config.forEach {
        when (it) {
            is String -> preference = it
            is Int -> mode = it
            is Context -> context = it
            is Boolean -> isAsync = it
            else -> Log.d("preferences-extension","The function does not accept the given type")
        }
    }

    val sharedPreferences: SharedPreferences =
        context!!.getSharedPreferences(preference, mode!!)

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


}

// Set data functions
fun String.saveDataWithConfig(config: List<Any>, key: String){
    configPreferencesFactory(
        config = config,
        key = key,
        data = this
    )

}

fun Int.saveDataWithConfig(config: List<Any>, key: String){
    configPreferencesFactory(
        config = config,
        key = key,
        data = this
    )

}

fun Float.saveDataWithConfig(config: List<Any>, key: String){
    configPreferencesFactory(
        config = config,
        key = key,
        data = this
    )

}

fun Boolean.saveDataWithConfig(config: List<Any>, key: String){
    configPreferencesFactory(
        config = config,
        key = key,
        data = this
    )

}

fun Long.saveDataWithConfig(config: List<Any>, key: String){
    configPreferencesFactory(
        config = config,
        key = key,
        data = this
    )

}

fun Set<*>.saveDataWithConfig(config: List<Any>, key: String){
    configPreferencesFactory(
        config = config,
        key = key,
        data = this
    )

}

fun List<*>.saveDataWithConfig(config: List<Any>, key: String) {
    configPreferencesFactory(
        config = config,
        key = key,
        data = this
    )
}
