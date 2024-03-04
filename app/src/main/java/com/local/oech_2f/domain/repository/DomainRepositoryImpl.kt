package com.local.oech_2f.domain.repository

import com.local.oech_2f.data.models.OnBoardingConstModel
import com.local.oech_2f.data.utils.ConstantsProvider
import javax.inject.Inject


class DomainRepositoryImpl @Inject constructor() : DomainRepository {
    companion object {
        lateinit var queue: List<OnBoardingConstModel>
    }

    init {
        queue = ConstantsProvider.provideConstants().getOnboardingData()
    }

    override fun nextPage(): OnBoardingConstModel {
        queue = queue.drop(1)
        return queue[0]
    }

    override fun skipPage(): OnBoardingConstModel {
        queue.dropWhile { queue.size != 1 }
        return queue[0]
    }
}