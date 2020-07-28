package com.tenniskata.app.viewmodel

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    internal var playerOneScore = 0
    internal var playerTwoScore = 0

    fun deuce() =
        playerOneScore >= 3 && playerTwoScore >= 3 && playerOneScore == playerTwoScore

    fun winsPlayerOne(): Boolean {
        return playerOneScore >= 4 && playerOneScore > playerTwoScore + 1
    }

    fun winsPlayerTwo(): Boolean {
        return playerTwoScore >= 4 && playerTwoScore > playerOneScore + 1
    }

    fun getScoreDescription(score: Int) = when (score) {
        1 -> "fifteen"
        else -> "love"
    }
}