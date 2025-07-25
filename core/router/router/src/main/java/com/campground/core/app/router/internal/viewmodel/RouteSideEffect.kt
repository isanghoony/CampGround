package com.campground.core.app.router.internal.viewmodel

import com.campground.app.core.router.api.model.Route

internal sealed interface RouteSideEffect {

    data class Navigate(
        val route: Route,
        val saveState: Boolean,
        val launchSingleTop: Boolean,
    ) : RouteSideEffect

    data class NavigateWeb(val url: String) : RouteSideEffect

    data object NavigateBack : RouteSideEffect
}
