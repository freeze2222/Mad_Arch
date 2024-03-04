package com.local.oech_2f.data.utils

import com.local.oech_2f.data.models.OnBoardingConstModel
import com.local.oech_2f.data.utils.Constants.ONBOARDING_ARTICLE_1
import com.local.oech_2f.data.utils.Constants.ONBOARDING_ARTICLE_2
import com.local.oech_2f.data.utils.Constants.ONBOARDING_ARTICLE_3
import com.local.oech_2f.data.utils.Constants.ONBOARDING_IMG_1
import com.local.oech_2f.data.utils.Constants.ONBOARDING_IMG_2
import com.local.oech_2f.data.utils.Constants.ONBOARDING_IMG_3
import com.local.oech_2f.data.utils.Constants.ONBOARDING_TITLE_1
import com.local.oech_2f.data.utils.Constants.ONBOARDING_TITLE_2
import com.local.oech_2f.data.utils.Constants.ONBOARDING_TITLE_3

class ConstantsApiImpl : ConstantsApi {
    override fun getOnboardingData(): List<OnBoardingConstModel> {
        return listOf(
            OnBoardingConstModel(ONBOARDING_IMG_1, false, ONBOARDING_TITLE_1, ONBOARDING_ARTICLE_1),
            OnBoardingConstModel(ONBOARDING_IMG_2, false, ONBOARDING_TITLE_2, ONBOARDING_ARTICLE_2),
            OnBoardingConstModel(ONBOARDING_IMG_3, true, ONBOARDING_TITLE_3, ONBOARDING_ARTICLE_3)
        )
    }
}