package com.example.preferences_extension.Extensions

import android.content.Context
import android.content.SharedPreferences

fun String.asyncSaveData(
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