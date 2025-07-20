package com.campground.app.feature.main

import com.campground.app.core.router.api.model.Route
import com.campground.app.feature.home.api.RouteHome

internal enum class ScreenName(
    internal val contentDescription: String,
    val route: Route
) {
    HOME(
        contentDescription = "Home",
        route = RouteHome
    )
}