package com.test.movies.utils

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

}