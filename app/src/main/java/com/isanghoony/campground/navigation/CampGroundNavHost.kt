package com.isanghoony.campground.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.isanghoony.campground.ui.CampGroundState
import com.isanghoony.home.navigation.HOME_GRAPH_ROUTE_PATTERN
import com.isanghoony.home.navigation.homeScreen
import com.isanghoony.mypage.navigation.myPageScreen

@Composable
fun CampGroundNavHost (
    campGroundState: CampGroundState,
    modifier: Modifier = Modifier,
    startDestination: String = HOME_GRAPH_ROUTE_PATTERN) {
    val navController = campGroundState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ){
        homeScreen { }
        myPageScreen {  }
    }
}