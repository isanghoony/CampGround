package com.campground.app.core.data.di

import com.campground.app.core.data.repository.CampRepository
import com.campground.app.core.data.repository.DefaultCampRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    internal abstract fun bindsUserDataRepository(campRepository: DefaultCampRepository): CampRepository
}