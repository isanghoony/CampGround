package com.campground.core.app.router.di

import com.campground.app.core.router.api.Navigator
import com.campground.core.app.router.internal.navigator.InternalNavigator
import com.campground.core.app.router.internal.navigator.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
internal abstract class RouterModel {

    @Binds
    @ActivityRetainedScoped
    abstract fun provideNavigator(
        navigator: NavigatorImpl
    ): Navigator

    @Binds
    @ActivityRetainedScoped
    abstract fun provideInternalNavigator(
        navigator: NavigatorImpl
    ): InternalNavigator
}
