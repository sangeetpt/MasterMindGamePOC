package com.test.mastermindgame

interface ValidateCallback {
    fun onSuccess(s: String?)
    fun onError(s: String?)
}