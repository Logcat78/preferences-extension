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
    @Test
    fun testSaveSet(){
        val set: Set<Int> = setOf(1,2)
        set.saveData("set14", "mainpopka", ApplicationProvider.getApplicationContext<Context>())
    }

    @Test
    fun testGetSet(){
        var set: Set<Int> = setOf(1)
        var popa = set.getData<Int>("set14", "mainpopka", ApplicationProvider.getApplicationContext<Context>())
        Log.d("gp", popa.toString())

        //assertEquals(setPenis, setOf("test", "test2"))
    }

    @Test
    fun testSaveList(){
        val list: List<Int> = listOf(1,2,3)
        list.saveData("list14", "mainpopka", ApplicationProvider.getApplicationContext<Context>())
    }

    @Test
    fun testGetList(){
        var list: List<Int> = listOf(1)
        var popa = list.getData<Int>("list14", "mainpopka", ApplicationProvider.getApplicationContext<Context>())
        Log.d("gp", popa.toString())

        //assertEquals(setPenis, setOf("test", "test2"))
    }

    @Test
    fun testSaveShort(){
        val short: Short = 1
        short.saveData("short14", "mainpopka", ApplicationProvider.getApplicationContext<Context>())
    }

    @Test
    fun testGetShort(){
        var short: Short = 1
        var popa = short.getData("short14", "mainpopka", ApplicationProvider.getApplicationContext<Context>())
        Log.d("gp", popa.toString())

        //assertEquals(setPenis, setOf("test", "test2"))
    }

    @Test
    fun testIntSave(){
        var int: Int = 1488
        var popa = int.saveData("int14", "mainpopka", ApplicationProvider.getApplicationContext<Context>())
        //Log.d("gp", popa.toString())

        //assertEquals(setPenis, setOf("test", "test2"))
    }

    @Test
    fun testIntGet(){
        var int: Int = 1
        var popa = int.getData("int14", "mainpopka", ApplicationProvider.getApplicationContext<Context>())
        Log.d("gp", popa.toString())

        //assertEquals(setPenis, setOf("test", "test2"))
    }
}