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
}