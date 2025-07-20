package com.campground.app.core.data.repository

import com.campground.app.core.model.CampBasic
import com.campground.core.app.network.CampResult

interface CampRepository {
    suspend fun getCampBasic(): CampResult<CampBasic>
}