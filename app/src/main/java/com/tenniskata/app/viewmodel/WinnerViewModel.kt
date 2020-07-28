package com.tenniskata.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class WinnerViewModel(application: Application, var playerName: String) :
    AndroidViewModel(application)