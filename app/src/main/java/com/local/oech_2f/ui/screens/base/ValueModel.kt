package com.local.oech_2f.ui.screens.base

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel

class ValueModel:ViewModel() {
    lateinit var text: MutableState<String>
}