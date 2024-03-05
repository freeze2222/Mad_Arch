package com.local.oech_2f.ui.composable

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OechButton(
    text: String,
    isEnabled: Boolean,
    modifier: Modifier = Modifier
        .height(50.dp)
        .width(100.dp),
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color(0xFF0560FA)
    ),
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = colors,
        shape = RoundedCornerShape(5.dp),
        enabled = isEnabled
    ) {
        Text(text = text, color = Color.White, fontSize = 14.sp)
    }
}
