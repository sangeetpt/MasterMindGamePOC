package com.test.movies.utils

import com.test.mastermindgame.RandomAlphaActivity
import java.util.Random

class Util {

    companion object{
        val ALLOWED_CHARACTERS = "qwertyuiopasdfghjklzxcvbnm"
        val RANDOM_ALPHA_LENGTH = 4
    }

    fun getRandomString(): String {
        val random = Random()
        val sb = StringBuilder(RANDOM_ALPHA_LENGTH)
        for (i in 0 until RANDOM_ALPHA_LENGTH)
            sb.append(ALLOWED_CHARACTERS[random.nextInt(ALLOWED_CHARACTERS.length)])
        return sb.toString()
    }

    fun compareResult(editTextPos: Int,userText : String,randomText : String): Int {
        var charAtPos : String = randomText.get(editTextPos).toString()
        if (userText == charAtPos) {
            return 0 //macth , green
        } else if ((randomText.contains(userText))) {
            return 1 // unmatch , yellow
        }else{
            return 2 // no match , red
        }
    }

}