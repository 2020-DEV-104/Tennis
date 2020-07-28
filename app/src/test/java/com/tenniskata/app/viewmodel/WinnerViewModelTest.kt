package com.tenniskata.app.viewmodel

import android.app.Application
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Test

class WinnerViewModelTest {
    @MockK
    lateinit var application: Application

    init {
        MockKAnnotations.init(this)
    }

    @Test
    fun `viewModel stores player One score`() {
        // Act
        val sut = WinnerViewModel(application, "one")

        // Assert
        assertEquals("one", sut.playerName)
    }
}