package com.local.oech_2f.ui.screens.onBoardingScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.local.oech_2f.data.models.OnBoardingConstModel
import com.local.oech_2f.data.utils.Constants
import com.local.oech_2f.ui.composable.OechButton

@Composable
fun OnBoardingScreen(navController: NavHostController) {
    val viewmodel = hiltViewModel<OnBoardingViewModel>()
    val state = viewmodel.state.collectAsState()

    OnBoardingScreenContent(state, viewmodel, navController)
}

@Composable
fun OnBoardingScreenContent(
    state: State<OnBoardingConstModel>, viewModel: OnBoardingViewModel, navController: NavHostController
) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Image(
                painter = painterResource(id = state.value.imageResource),
                contentDescription = null,
                modifier = Modifier.size(346.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = state.value.title,
                color = Color(0xFF0560FA),
                fontSize = 24.sp,
                minLines = 2,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(700)
            )
            Text(
                text = state.value.article,
                color = Color(0xFF3A3A3A),
                fontSize = 16.sp,
                minLines = 2,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(600),
                modifier = Modifier.height(80.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))

            if (!state.value.isFinal) {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Spacer(modifier = Modifier.height(30.dp))
                    Button(
                        onClick = { viewModel.skipPage() },
                        modifier = Modifier
                            .height(50.dp)
                            .width(100.dp)
                            .border(1.dp, Color(0xFF0560FA), shape = RoundedCornerShape(5.dp)),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text(text = "Skip", color = Color(0xFF0560FA), fontSize = 14.sp)
                    }

                    Spacer(Modifier.width(110.dp))
                    OechButton(text = "Next") {
                        viewModel.nextPage()
                    }
                }
            } else {
                Button(
                    onClick = { navController.navigate(Constants.HOLDER) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0560FA)),
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier
                        .height(60.dp)
                        .width(342.dp)
                ) {
                    Text(
                        text = "Sign Up", fontWeight = FontWeight(600), color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Text(text = "Already have an account?")
                    Text(
                        text = AnnotatedString("Sign in"),
                        color = Color(0xFF0560FA),
                        modifier = Modifier.clickable {
                            navController.navigate(Constants.HOLDER)
                        })
                }
            }
        }
    }
}

