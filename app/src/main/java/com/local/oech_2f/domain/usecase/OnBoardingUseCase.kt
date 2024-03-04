package com.local.oech_2f.domain.usecase

import com.local.oech_2f.data.models.OnBoardingConstModel
import com.local.oech_2f.domain.repository.DomainRepositoryImpl
import javax.inject.Inject

class OnBoardingUseCase @Inject constructor(private val domainRepositoryImpl: DomainRepositoryImpl) {
    fun nextPage(): OnBoardingConstModel {
        return domainRepositoryImpl.nextPage()
    }
    fun skipPage(): OnBoardingConstModel {
        return domainRepositoryImpl.skipPage()
    }
}