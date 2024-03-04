package com.local.oech_2f.data.utils

import com.local.oech_2f.data.models.Example
import com.local.oech_2f.data.models.OnBoardingConstModel
import retrofit2.Call
import retrofit2.http.GET

interface OECHApi {
    @GET("/")
    fun getExample():Call<Example>
}

interface ConstantsApi{
    fun getOnboardingData():List<OnBoardingConstModel>
}