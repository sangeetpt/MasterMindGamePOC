package com.test.mastermindgame

import android.app.Application
import com.test.movies.utils.Util
import org.hamcrest.CoreMatchers
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RandomAlphaUnitTest {

    lateinit var utilInstance: Util
    private val target = RandomAlphaViewModel(Application())

    @Before
    fun setUp(){
        utilInstance = Util()
        utilInstance.getRandomString()
    }


    @Test
    fun compareResult(){

        assertEquals(utilInstance.compareResult(0,"a","aeik"),0)//
        assertEquals(utilInstance.compareResult(1,"x","aeik"),2)
        assertEquals(utilInstance.compareResult(2,"k","aeik"),1)
        assertEquals(utilInstance.compareResult(3,"i","aeik"),1)
    }
}