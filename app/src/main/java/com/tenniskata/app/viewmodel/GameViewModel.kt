package com.tenniskata.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    internal var playerOneScore = 0
    internal var playerTwoScore = 0
    private val _scoreDescription = MutableLiveData<String>("Love")
    val scoreDescription: LiveData<String> = _scoreDescription

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
        return if (winsPlayerOne())
            "Player one wins"
        else if (winsPlayerTwo())
            "Player two wins"
        else if (deuce())
            "Deuce"
        else if (playerOneAdvantage())
            "Advantage player one"
        else if (playerTwoAdvantage())
            "Advantage player two"
        else if (playerOneScore == playerTwoScore)
            getScoreDescription(playerOneScore)
        else
            getScoreDescription(playerOneScore) + " - " + getScoreDescription(playerTwoScore)
    }

    fun playerOneScores() {
        playerOneScore++
        _scoreDescription.value = getScoreboard()
    }

    fun playerTwoScores() {
        playerTwoScore++
        _scoreDescription.value = getScoreboard()
    }
}