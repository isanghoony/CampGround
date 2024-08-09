package com.isanghoony.campground.repository

import com.isanghoony.model.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {
    val userData: Flow<UserData>
}