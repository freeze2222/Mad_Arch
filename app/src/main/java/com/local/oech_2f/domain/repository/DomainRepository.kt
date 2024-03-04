package com.local.oech_2f.domain.repository

import com.local.oech_2f.data.models.OnBoardingConstModel

interface DomainRepository {
    fun nextPage(): OnBoardingConstModel
    fun skipPage(): OnBoardingConstModel
}