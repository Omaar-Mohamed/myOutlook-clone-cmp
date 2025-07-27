package org.example.myoutlook

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import myoutlook.composeapp.generated.resources.Res
import myoutlook.composeapp.generated.resources.compose_multiplatform
import org.example.myoutlook.data.Repo.AuthRepositoryImpl
import org.example.myoutlook.domain.repo.AuthRepo
import org.example.myoutlook.domain.useCases.LoginUserUseCase
import org.example.myoutlook.presentation.auth.AuthScreen
import org.example.myoutlook.presentation.auth.AuthViewModel
import org.example.myoutlook.presentation.auth.AuthViewModelFactory

@Composable
@Preview
fun App() {
    MaterialTheme {
        // Create and remember the ViewModel
        val viewModel = remember {
            AuthViewModelFactory().create(AuthViewModel::class)
        }

        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AuthScreen(viewModel = viewModel)
        }
    }
}

