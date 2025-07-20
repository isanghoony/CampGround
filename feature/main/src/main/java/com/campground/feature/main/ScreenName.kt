package com.campground.feature.main

import com.campground.core.router.api.model.Route
import com.campground.feature.home.api.RouteHome

internal enum class ScreenName(
    internal val contentDescription: String,
    val route: Route
) {
    HOME(
        contentDescription = "Home",
        route = RouteHome
    )
}