package com.campground.core.app.router.internal.navigator

import kotlinx.coroutines.channels.Channel

internal interface InternalNavigator {

    val channel: Channel<InternalRoute>
}
