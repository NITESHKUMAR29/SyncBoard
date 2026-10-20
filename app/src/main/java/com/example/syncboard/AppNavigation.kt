package com.example.syncboard

import SignUpScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.auth.screen.LoginScreen
import com.example.navigation.LoginRoute
import com.example.navigation.SignUpRoute

@Composable
fun AppNavigation (navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = LoginRoute, modifier = modifier) {
        composable<LoginRoute> {
            LoginScreen(onSignUpClick = {
                navController.navigate(SignUpRoute)
            })
        }

        composable<SignUpRoute> {
            SignUpScreen(onLoginClick = {
                navController.navigate(LoginRoute)
            })
        }

    }
}