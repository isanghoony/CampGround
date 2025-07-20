package com.campground.core.router.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.campground.core.router.internal.viewmodel.RouteSideEffect
import com.campground.core.router.internal.viewmodel.RouterViewModel
import kotlinx.coroutines.flow.collectLatest

/**
 * 외부에서 호출되는 Composable. 내부에서 실제 라우팅 로직을 담당하는 InternalLaunchedRouter를 호출함.
 * - navHostController: Compose Navigation 컨트롤러
 * - uriHandler: 외부 URI (웹 링크 등) 열기 위한 핸들러 (기본값: LocalUriHandler.current)
 */
@Composable
fun LaunchedRouter(
    navHostController: NavHostController,
    uriHandler: UriHandler = LocalUriHandler.current,
) {
    InternalLaunchedRouter(
        navHostController = navHostController,
        uriHandler = uriHandler,
    )
}

/**
 * 실제 라우팅 이벤트를 처리하는 Composable
 * - RouterViewModel의 sideEffect Flow를 구독하여 Navigation 수행
 */
@Composable
private fun InternalLaunchedRouter(
    navHostController: NavHostController,
    uriHandler: UriHandler,
    routerViewModel: RouterViewModel = hiltViewModel(),
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(routerViewModel, lifecycleOwner) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            routerViewModel.sideEffect.collectLatest { sideEffect ->
                when (sideEffect) {
                    is RouteSideEffect.NavigateBack -> {
                        navHostController.popBackStack()
                    }

                    is RouteSideEffect.NavigateWeb -> {
                        uriHandler.openUri(sideEffect.url)
                    }

                    is RouteSideEffect.Navigate -> {
                        navHostController.navigate(sideEffect.route.name) {
                            if (sideEffect.saveState) {
                                navHostController.graph.findStartDestination().route?.let {
                                    popUpTo(it) {
                                        saveState = true
                                    }
                                }
                                restoreState = true
                            }
                            launchSingleTop = sideEffect.launchSingleTop
                        }
                    }
                }
            }
        }
    }
}
