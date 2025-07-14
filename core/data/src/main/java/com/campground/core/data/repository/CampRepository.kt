package com.campground.core.data.repository

import com.campground.core.model.CampBasic
import com.campground.core.network.CampResult

interface CampRepository {
    suspend fun getCampBasic(): CampResult<CampBasic>
}