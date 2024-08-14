package com.isanghoony.campground.repository

import com.isanghoony.model.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class MyPageUserDataRepository @Inject constructor(

) : UserDataRepository {
    override val userData: Flow<UserData>
        get() = TODO("Not yet implemented")
}