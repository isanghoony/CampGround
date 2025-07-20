package com.campground.app.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.campground.core.app.router.internal.LaunchedRouter
import com.campground.app.core.designsystem.theme.CampGroundTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navigator: MainNavigator = rememberMainNavigator()

            LaunchedRouter(navigator.navController)

            CampGroundTheme {
                MainScreen(navigator = navigator)
            }
        }
    }
}
