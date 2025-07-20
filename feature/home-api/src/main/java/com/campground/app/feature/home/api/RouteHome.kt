package com.campground.app.feature.home.api

import com.campground.app.core.router.api.model.Route
import kotlinx.serialization.Serializable

@Serializable
data object RouteHome : Route {
    override val name: String
        get() = "home"
}