package com.local.oech_2f.ui.screens.signupScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.local.oech_2f.ui.composable.OechButton
import com.local.oech_2f.ui.composable.OechOutlinedTextField
import com.local.oech_2f.ui.screens.base.ValueModel

@Composable
fun SignupScreen() {

}

@Composable
fun SignupScreenContent() {
    val fullname = ValueModel().apply { text = remember { mutableStateOf("") } }
    val phone = ValueModel().apply { text = remember { mutableStateOf("") } }
    val email = ValueModel().apply { text = remember { mutableStateOf("") } }
    val password = ValueModel().apply { text = remember { mutableStateOf("") } }
    val passwordConfirmation = ValueModel().apply { text = remember { mutableStateOf("") } }
    var check by remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Create an account", fontWeight = FontWeight(500), fontSize = 24.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Complete the sign up process to get started",
                fontWeight = FontWeight(500),
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Full name", color = Color.Gray, fontWeight = FontWeight(500))
            OutlinedTextField(
                value = fullname.text.value,
                onValueChange = { fullname.text.value = it },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black, unfocusedTextColor = Color.Black
                ),
                label = {
                    if (fullname.text.value.isEmpty()) {
                        Text(text = "Ivanov Ivan", color = Color.Gray, fontWeight = FontWeight(500))
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Phone Number", color = Color.Gray, fontWeight = FontWeight(500))
            OechOutlinedTextField(model = phone, placeholer = "+7(999)999-99-99")
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Email Address", color = Color.Gray, fontWeight = FontWeight(500))
            OechOutlinedTextField(model = email, placeholer = "***********@mail.com")
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Password", color = Color.Gray, fontWeight = FontWeight(500))
            OechOutlinedTextField(model = password, placeholer = "**********", isPassword = true)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Confirm Password", color = Color.Gray, fontWeight = FontWeight(500))
            OechOutlinedTextField(model = passwordConfirmation, placeholer = "**********", isPassword = true)
            Spacer(modifier = Modifier.height(20.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = check, onCheckedChange = { check = it })
                Spacer(modifier = Modifier.width(10.dp))
                val annotatedString = buildAnnotatedString {
                    append("By ticking this box, you agree to our")
                    withStyle(SpanStyle(color = Color(0xFFEBBC2E))) {
                        pushStringAnnotation("tick", "tick")
                        append(" Terms and conditions and private policy")
                        pop()
                    }
                }
                val context = LocalContext.current
                ClickableText(
                    text = annotatedString,
                    style = TextStyle(textAlign = TextAlign.Center, color = Color.Gray)
                ) { it ->
                    annotatedString.getStringAnnotations("tick", it, it).firstOrNull().let {
                        if (it != null) {
                            if (it.tag == "tick") {
                                Toast.makeText(context, "1234", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            OechButton(
                text = "Sign Up",
                colors = ButtonDefaults.buttonColors(
                    disabledContainerColor = Color.Gray, containerColor = Color(0xFF0560FA)
                ),
                isEnabled = check && fullname.text.value.isNotEmpty() && phone.text.value.isNotEmpty() && email.text.value.isNotEmpty() && password.text.value.isNotEmpty() && passwordConfirmation.text.value.isNotEmpty(),
                modifier = Modifier.fillMaxWidth()
            ) {

            }
        }
    }
}

@Preview
@Composable
private fun prev() {
    SignupScreenContent()
}