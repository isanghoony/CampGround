package com.isanghoony.campground.di

import com.isanghoony.campground.repository.MyPageUserDataRepository
import com.isanghoony.campground.repository.UserDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    internal abstract fun bindsUserDataRepository(userDataRepository: MyPageUserDataRepository): UserDataRepository
}