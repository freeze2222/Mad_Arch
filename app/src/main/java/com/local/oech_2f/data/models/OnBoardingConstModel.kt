package com.local.oech_2f.data.models

import com.local.oech_2f.R

data class OnBoardingConstModel(
    var imageResource: Int = R.drawable.onboarding_1,
    var isFinal : Boolean = false,
    var title: String = "Quick Delivery At Your\nDoorstep",
    var article: String = "Enjoy quick pick-up and delivery to\nyour destination"
)
