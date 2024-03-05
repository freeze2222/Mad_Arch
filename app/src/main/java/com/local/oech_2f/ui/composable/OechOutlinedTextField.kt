package com.local.oech_2f.ui.composable

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.local.oech_2f.R
import com.local.oech_2f.ui.screens.base.ValueModel

@Composable
fun OechOutlinedTextField(model: ValueModel, placeholer: String, isPassword: Boolean = false) {
    var isHidden by remember {
        mutableStateOf(isPassword)
    }
    val trailing = @Composable {
        Image(painter = painterResource(id = R.drawable.eye),
            contentDescription = null,
            modifier = Modifier
                .size(14.dp)
                .clickable {
                    isHidden = !isHidden
                })
    }
    val trailingEmpty = @Composable {
        Spacer(Modifier)
    }
    OutlinedTextField(
        value = model.text.value,
        onValueChange = { model.text.value = it },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black, unfocusedTextColor = Color.Black
        ),
        label = {
            if (model.text.value.isEmpty()) {
                Text(
                    text = placeholer, color = Color.Gray, fontWeight = FontWeight(500)
                )
            }
        },
        visualTransformation = if (isHidden) {
            PasswordVisualTransformation()
        } else VisualTransformation.None,
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = if (isPassword) trailing else trailingEmpty
    )
}