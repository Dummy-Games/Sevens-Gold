package com.getter.kollytsi.ui

import androidx.lifecycle.MutableLiveData

object Values {
    var score = 800
    var listOfResultImages = mutableListOf(100, 100, 100)
    var endOfGame: MutableLiveData<Boolean> = MutableLiveData(false)
}
