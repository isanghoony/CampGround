package com.isanghoony.campground.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.util.trace
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.isanghoony.campground.navigation.TopLevelDestination
import com.isanghoony.home.navigation.HOME_ROUTE
import com.isanghoony.home.navigation.navigationToHomeGraph
import com.isanghoony.mypage.navigation.MY_PAGE_ROUTE
import com.isanghoony.mypage.navigation.navigationToMyPageGraph
import com.isanghoony.ui.TrackDisposableJank
import kotlinx.coroutines.CoroutineScope


@Composable
fun rememberCampGroundState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()) : CampGroundState{

    NavigationTrackingSideEffect(navController)

    return remember(navController, coroutineScope) { CampGroundState(navController, coroutineScope) }
}


@Stable
class CampGroundState(val navController: NavHostController,val coroutineScope: CoroutineScope){
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            HOME_ROUTE -> TopLevelDestination.HOME
            MY_PAGE_ROUTE -> TopLevelDestination.MY_PAGE
            else -> null
        }

    val topDestinations : List<TopLevelDestination> = TopLevelDestination.entries

    fun navigateToTopDestination(topDestination: TopLevelDestination) {
        trace("Navigation: ${topDestination.name}") {
            val topNavOptions = navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }

            when (topDestination) {
                TopLevelDestination.HOME -> navController.navigationToHomeGraph(topNavOptions)
                TopLevelDestination.MY_PAGE -> navController.navigationToMyPageGraph(topNavOptions)
            }
        }
    }

}


@Composable
private fun NavigationTrackingSideEffect(navController: NavHostController) {
    TrackDisposableJank(navController) { metricsHolder ->
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            metricsHolder.state?.putState("Navigation", destination.route.toString())
        }

        navController.addOnDestinationChangedListener(listener)

        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }
}
