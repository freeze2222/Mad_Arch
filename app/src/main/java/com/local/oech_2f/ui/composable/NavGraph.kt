package com.local.oech_2f.ui.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.local.oech_2f.data.utils.Constants
import com.local.oech_2f.ui.screens.onBoardingScreen.OnBoardingScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Constants.ONBOARDING_SCREEN){
        composable(route = Constants.ONBOARDING_SCREEN){
            OnBoardingScreen(navController = navController)
        }
        composable(route = Constants.HOLDER){
            //TODO
        }
    }
}