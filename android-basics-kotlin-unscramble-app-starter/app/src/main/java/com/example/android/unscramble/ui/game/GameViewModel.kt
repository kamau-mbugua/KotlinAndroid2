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

    /*
* Updates currentWord and currentScrambledWord with the next word.
*/
    private fun getNextWord() {
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()
        while (tempWord.toString().equals(currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++currentWordCount
            wordsList.add(currentWord)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }


}