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
import com.isanghoony.home.navigation.navigationToHomeHomeScreen
import com.isanghoony.mypage.navigation.MY_PAGE_ROUTE
import com.isanghoony.mypage.navigation.navigationToMyPageScreen
import com.isanghoony.ui.TrackDisposableJank
import kotlinx.coroutines.CoroutineScope

// Composable 함수로 CampGroundState를 기억하고 반환
@Composable
fun rememberCampGroundState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()) : CampGroundState{

    NavigationTrackingSideEffect(navController)

    return remember(navController, coroutineScope) { CampGroundState(navController, coroutineScope) }
}

// Stable 어노테이션이 붙은 클래스, 네비게이션 상태를 관리
@Stable
class CampGroundState(val navController: NavHostController, val coroutineScope: CoroutineScope) {
    // 현재 목적지를 가져오는 프로퍼티
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    // 현재 TopLevel 목적지를 가져오는 프로퍼티
    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            HOME_ROUTE -> TopLevelDestination.HOME
            MY_PAGE_ROUTE -> TopLevelDestination.MY_PAGE
            else -> null
        }

    // TopLevel 목적지 리스트
    val topDestinations : List<TopLevelDestination> = TopLevelDestination.entries

    // TopLevel 목적지로 네비게이션하는 함수
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
                TopLevelDestination.HOME -> navController.navigationToHomeHomeScreen(topNavOptions)
                TopLevelDestination.MY_PAGE -> navController.navigationToMyPageScreen(topNavOptions)
            }
        }
    }
}

// 네비게이션 상태를 추적하는 사이드 이펙트 함수
@Composable
private fun NavigationTrackingSideEffect(navController: NavHostController) {
    TrackDisposableJank(navController) { metricsHolder ->
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            metricsHolder.state?.putState("Navigation", destination.route.toString())
        }

        navController.addOnDestinationChangedListener(listener)

        // 컴포저블이 제거될 때 리스너를 제거
        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }
}
