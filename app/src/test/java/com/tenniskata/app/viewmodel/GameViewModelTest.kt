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
}