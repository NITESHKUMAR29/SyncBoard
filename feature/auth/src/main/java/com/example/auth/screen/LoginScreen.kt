package com.example.auth.screen

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberBasicTooltipState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.auth.viewmodel.AuthViewmodel
import com.example.designsystem.component.HorizontalSpace
import com.example.designsystem.component.InputBoxTitleText
import com.example.designsystem.component.SyncBoardButton
import com.example.designsystem.component.SyncBoardLogo
import com.example.designsystem.component.SyncManagerInput
import com.example.designsystem.component.VerticalSpace

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier, onSignUpClick: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    val viewModel: AuthViewmodel = hiltViewModel()
    val uiState by viewModel.login.collectAsState()
    if (uiState.isSuccessful) {
        Log.d("LoginScreen", uiState.data.toString())
    }

    if (uiState.error != null) {
        Log.d("LoginScreen", uiState.error.toString())
    }

    if (uiState.isLoading) {
        Log.d("LoginScreen", "Loading")
    }
    Column(
        modifier = modifier
            .padding(horizontal = 24.dp, vertical = 48.dp)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            SyncBoardLogo(size = 34.dp)
            HorizontalSpace(10)
            Text(
                text = "Sync Board", style = MaterialTheme.typography.displaySmall
            )
        }

        VerticalSpace(30)

        Column {
            Text(
                text = "Welcome back", style = MaterialTheme.typography.displayLarge
            )
            VerticalSpace(10)
            Text(
                text = "Log in to pick up where your team left off.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        VerticalSpace(30)
        InputBoxTitleText("Email")
        VerticalSpace(8)
        SyncManagerInput(email, onValueChange = { email = it })
        VerticalSpace(20)
        InputBoxTitleText("Password")
        VerticalSpace(8)
        SyncManagerInput(
            password,
            onValueChange = { password = it },
            isPassword = true
        )
        VerticalSpace(24)
        SyncBoardButton("Log in", onClick = {
                viewModel.login(email, password)
        })
        VerticalSpace(24)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "New to task flow?",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            HorizontalSpace(8)
            Text(
                text = "Create an account",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.clickable(onClick = onSignUpClick)
            )
        }
    }
}
