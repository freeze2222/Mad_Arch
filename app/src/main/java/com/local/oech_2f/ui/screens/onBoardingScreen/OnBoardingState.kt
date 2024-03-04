package com.local.oech_2f.ui.screens.onBoardingScreen

import com.local.oech_2f.R

data class OnBoardingState(
    var imageResource: Int = R.drawable.onboarding_1,
    var isFinal: Boolean = false,
    var title: String = "Quick Delivery At Your\nDoorstep",
    var article: String = "Enjoy quick pick-up and delivery to\nyour destination"
) {
    fun deserialize(input: List<Any>): OnBoardingState {
        return OnBoardingState(
            input[0] as Int,
            input[1] as Boolean,
            input[2] as String,
            input[3] as String
        )
    }
}
