package com.example.startup_forge.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class NavigationState: ViewModel() {
    var currentDirectory: String by mutableStateOf("")
}