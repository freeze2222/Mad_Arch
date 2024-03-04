package com.local.oech_2f.ui.screens.onBoardingScreen

import androidx.lifecycle.ViewModel
import com.local.oech_2f.data.models.OnBoardingConstModel
import com.local.oech_2f.domain.usecase.OnBoardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val useCase: OnBoardingUseCase) :
    ViewModel() {
    private val _state = MutableStateFlow(OnBoardingState())

    val state: StateFlow<OnBoardingState>
        get() = _state.asStateFlow()

    init {
        useCase.initialize()
    }
    fun nextPage() {
        val queue = OnBoardingState().deserialize(useCase.nextPage().serialize())
        emit(queue)
    }

    fun skipPage() {
        val queue = OnBoardingState().deserialize(useCase.skipPage().serialize())
        emit(queue)
    }

    private fun emit(queue: OnBoardingState) {
        _state.tryEmit(queue)
    }

}
