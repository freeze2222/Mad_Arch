package com.local.oech_2f

import androidx.hilt.navigation.compose.hiltViewModel
import com.local.oech_2f.domain.repository.DomainRepositoryImpl
import com.local.oech_2f.domain.usecase.OnBoardingUseCase
import com.local.oech_2f.ui.screens.onBoardingScreen.OnBoardingViewModel
import org.junit.Test

class OnBoardingTest {
    @Test
    fun onBoardingTest() {
        val viewModel = OnBoardingViewModel(OnBoardingUseCase(DomainRepositoryImpl()))
    }
}