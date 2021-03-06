package com.tenniskata.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    internal var playerOneScore = 0
    internal var playerTwoScore = 0
    private val _scoreDescription = MutableLiveData<String>("Love")
    val scoreDescription: LiveData<String> = _scoreDescription

    private val _winnerName = MutableLiveData<String>()
    val winnerName: LiveData<String> = _winnerName

    fun deuce() =
        playerOneScore >= 3 && playerTwoScore >= 3 && playerOneScore == playerTwoScore

    fun winsPlayerOne(): Boolean {
        return playerOneScore >= 4 && playerOneScore > playerTwoScore + 1
    }

    fun winsPlayerTwo(): Boolean {
        return playerTwoScore >= 4 && playerTwoScore > playerOneScore + 1
    }

    fun getScoreDescription(score: Int) = when (score) {
        1 -> "Fifteen"
        2 -> "Thirty"
        3 -> "Forty"
        else -> "Love"
    }

    fun playerOneAdvantage() = playerOneScore >= 3 && playerTwoScore >= 3
            && playerOneScore == playerTwoScore + 1

    fun playerTwoAdvantage() = playerOneScore >= 3 && playerTwoScore >= 3
            && playerOneScore + 1 == playerTwoScore

    fun hasWinner() = winsPlayerOne() || winsPlayerTwo()
    fun getScoreboard(): String {
        return when {
            winsPlayerOne() -> "Player one wins"
            winsPlayerTwo() -> "Player two wins"
            deuce() -> "Deuce"
            playerOneAdvantage() -> "Advantage player one"
            playerTwoAdvantage() -> "Advantage player two"
            playerOneScore == playerTwoScore -> getScoreDescription(playerOneScore)
            else -> getScoreDescription(playerOneScore) + " - " + getScoreDescription(playerTwoScore)
        }
    }

    fun playerOneScores() {
        playerOneScore++
        _scoreDescription.value = getScoreboard()
        if (winsPlayerOne())
            _winnerName.value = "one"
    }

    fun playerTwoScores() {
        playerTwoScore++
        _scoreDescription.value = getScoreboard()
        if (winsPlayerTwo())
            _winnerName.value = "two"
    }

    fun doneNavigating() {
        _winnerName.value = null
        playerOneScore = 0
        playerTwoScore = 0
        _scoreDescription.value = "Love"
    }
}