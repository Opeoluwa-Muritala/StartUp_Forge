package com.example.startup_forge.ViewModels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TextState: ViewModel() {
    val _state = MutableStateFlow(String)
    val state = _state.asStateFlow()


    /*ToDo*/
}