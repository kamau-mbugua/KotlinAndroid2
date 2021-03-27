package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel:ViewModel() {
    var score = 0
    var currentWordCount = 0
    var _currentScrambledWord = "test"
    val  currentScrambledWord: String
    get() = _currentScrambledWord

    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    private fun getNextWord() {
        currentWord = allWordsList.random()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }


}