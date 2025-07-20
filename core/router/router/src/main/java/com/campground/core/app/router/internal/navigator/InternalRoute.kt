package com.campground.core.app.router.internal.navigator

import com.campground.app.core.router.api.model.Route

internal sealed interface InternalRoute {

    data class Navigate(
        val route: Route,
        val saveState: Boolean,
        val launchSingleTop: Boolean,
    ) : InternalRoute

    data class NavigateWeb(val url: String) : InternalRoute

    data object NavigateBack : InternalRoute
}
