package com.tenniskata.app.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * A factory for the Winner View Model to pass the player name
 */
@Suppress("UNCHECKED_CAST")
class WinnerViewModelFactory(
    private val application: Application,
    private val playerName: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WinnerViewModel::class.java)) {
            return WinnerViewModel(application, playerName) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}