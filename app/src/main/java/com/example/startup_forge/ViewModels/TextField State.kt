package com.example.startup_forge.ViewModels

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException


class TextFieldViewModel(
): ViewModel(){
    val myData by mutableStateOf("")
}

class PasswordIconViewModel(
): ViewModel(){
    val myData by mutableStateOf(true)
}