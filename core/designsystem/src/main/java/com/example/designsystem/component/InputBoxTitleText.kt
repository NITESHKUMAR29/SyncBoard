package com.example.designsystem.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun InputBoxTitleText (title: String){
    Text(text = title,style = MaterialTheme.typography.bodyLarge)
}