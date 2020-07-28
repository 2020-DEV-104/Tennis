package com.tenniskata.app.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class GameViewModelTest {
    @get:Rule
    var testRule: TestRule = InstantTaskExecutorRule()

    private var sut = GameViewModel()

    @Test
    fun `viewModel stores player One score`() {
        // Act
        sut.playerOneScore = 1

        // Assert
        assertEquals(1, sut.playerOneScore)
    }

    @Test
    fun `viewModel stores player Two score`() {
        // Act
        sut.playerTwoScore = 2

        // Assert
        assertEquals(2, sut.playerTwoScore)
    }


    @Test
    fun `if a player score is less than 3 they are not in deuce`() {
        // Arrange
        sut.playerOneScore = 1
        sut.playerTwoScore = 3

        // Act
        val result = sut.deuce()

        // Assert
        assertFalse(result)
    }

    @Test
    fun `if both scores are different they are not in deuce`() {
        // Arrange
        sut.playerOneScore = 3
        sut.playerTwoScore = 4

        // Act
        val result = sut.deuce()

        // Assert
        assertFalse(result)
    }

    @Test
    fun `if both scores are equal and above 3 they are in deuce`() {
        // Arrange
        sut.playerOneScore = 4
        sut.playerTwoScore = 4

        // Act
        val result = sut.deuce()

        // Assert
        assertTrue(result)
    }


    @Test
    fun `if a player score is more than 4 he has won *(more rules apply)`() {
        // Arrange
        sut.playerOneScore = 1
        sut.playerTwoScore = 4

        // Act
        val resultPlayerOne = sut.winsPlayerOne()
        val resultPlayerTwo = sut.winsPlayerTwo()

        // Assert
        assertFalse(resultPlayerOne)
        assertTrue(resultPlayerTwo)
    }

    @Test
    fun `player One can not win if it has not two points of advantage`() {
        // Arrange
        sut.playerOneScore = 4
        sut.playerTwoScore = 3

        // Act
        val resultPlayerOne = sut.winsPlayerOne()

        // Assert
        assertFalse(resultPlayerOne)
    }

    @Test
    fun `player Two can not win if it has not two points of advantage`() {
        // Arrange
        sut.playerOneScore = 3
        sut.playerTwoScore = 4

        // Act
        val resultPlayerTwo = sut.winsPlayerTwo()

        // Assert
        assertFalse(resultPlayerTwo)
    }

    @Test
    fun `score 0 is described as love`() {
        // Act
        val result = sut.getScoreDescription(0)

        // Assert
        assertEquals("love", result)
    }

    @Test
    fun `score 1 is described as fifteen`() {
        // Act
        val result = sut.getScoreDescription(1)

        // Assert
        assertEquals("fifteen", result)
    }

    @Test
    fun `score 2 is described as thirty`() {
        // Act
        val result = sut.getScoreDescription(2)

        // Assert
        assertEquals("thirty", result)
    }

    @Test
    fun `score 3 is described as forty`() {
        // Act
        val result = sut.getScoreDescription(3)

        // Assert
        assertEquals("forty", result)
    }


    @Test
    fun `player One has advantage if both players have more than 3 points *(more rules apply)`() {
        // Arrange
        sut.playerOneScore = 4
        sut.playerTwoScore = 3

        // Act
        val result = sut.playerOneAdvantage()

        // Assert
        assertTrue(result)
    }

    @Test
    fun `player One has advantage if it has one more point than his opponent`() {
        // Arrange
        sut.playerOneScore = 4
        sut.playerTwoScore = 4

        // Act
        val result = sut.playerOneAdvantage()

        // Assert
        assertFalse(result)
    }

    @Test
    fun `player Two has advantage if both players have more than 3 points *(more rules apply)`() {
        // Arrange
        sut.playerOneScore = 3
        sut.playerTwoScore = 4

        // Act
        val result = sut.playerTwoAdvantage()

        // Assert
        assertTrue(result)
    }

    @Test
    fun `player Two has advantage if it has one more point than his opponent`() {
        // Arrange
        sut.playerOneScore = 4
        sut.playerTwoScore = 4

        // Act
        val result = sut.playerTwoAdvantage()

        // Assert
        assertFalse(result)
    }

}