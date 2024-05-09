package com.example.preferences_extension

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.preferences_extension.Extensions.getData
import com.example.preferences_extension.Extensions.saveData
import com.example.preferences_extension.Extensions.saveDataWithConfig

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        Log.d("gp", "test")
    }

    @Test
    fun saveWithConfig(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val a: String = "писундара"
        val abdf: List<String> = listOf()
        val config: List<Any> = listOf(
            context,
            "пипиндра",
            Context.MODE_PRIVATE,
            true
        )
        a.saveDataWithConfig(config, "ключ")
    }



    @Test
    fun testClassicGet(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("test data", Context.MODE_PRIVATE)
    }
    @Test
    fun testNewSave(){
        val text: String = "test data"
        text.saveData("data", "main",  ApplicationProvider.getApplicationContext<Context>())
    }
    @Test
    fun testNewGet(){
        val text = "".getData("data",  "main", ApplicationProvider.getApplicationContext<Context>())
        Log.d("gp", text)
    }
}