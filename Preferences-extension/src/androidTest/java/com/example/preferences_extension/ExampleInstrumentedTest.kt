package com.example.preferences_extension

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.preferences_extension.Extensions.asyncSaveData
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
    fun testAsyncSaveString(){
        val data: String = "string123"
        val newData = "".getData("string", "mainData", ApplicationProvider.getApplicationContext<Context>())
        assertEquals("string123", newData)
    }


    @Test
    fun testSaveShort(){
        val data: Short = 10
        val newData = data.getData("short", "mainData", ApplicationProvider.getApplicationContext<Context>())
        assertEquals(data, newData)
    }

    @Test
    fun testSaveList(){
        val data: ArrayList<String> = arrayListOf<String>("string1", "string2")
        val newData = listOf<String>("").getData<String>("list", "mainData", ApplicationProvider.getApplicationContext<Context>())
        assertEquals(listOf("string1", "string2"), newData)
    }

    @Test
    fun testSaveIntWithConfig(){
        val data: Int = 15
        val newData = data.getData("int", "mainData", ApplicationProvider.getApplicationContext<Context>())
        assertEquals(15, newData)
    }

    @Test
    fun testSaveIListWithConfig(){
        val data: List<Int> = listOf(10, 20)
        val newData = data.getData<Int>("list", "mainData", ApplicationProvider.getApplicationContext<Context>())
        assertEquals(listOf(10, 20), newData)
    }


}