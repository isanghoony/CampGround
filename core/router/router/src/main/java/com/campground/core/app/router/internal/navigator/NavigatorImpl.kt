package com.campground.core.app.router.internal.navigator

import com.campground.app.core.router.api.Navigator
import com.campground.app.core.router.api.model.Route
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

@ActivityRetainedScoped
internal class NavigatorImpl @Inject constructor() : Navigator, InternalNavigator {

    override val channel = Channel<InternalRoute>(Channel.BUFFERED)

    override suspend fun navigate(route: Route, saveState: Boolean, launchSingleTop: Boolean) {
        channel.send(
            InternalRoute.Navigate(
                route = route,
                saveState = saveState,
                launchSingleTop = launchSingleTop,
            )
        )
    }

    override suspend fun navigateWeb(url: String) {
        channel.send(InternalRoute.NavigateWeb(url = url))
    }

    override suspend fun navigateBack() {
        channel.send(InternalRoute.NavigateBack)
    }
}
