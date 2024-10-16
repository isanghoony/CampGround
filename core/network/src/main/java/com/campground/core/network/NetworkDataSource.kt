package com.campground.core.network

import com.campground.core.model.CampBasic
import com.campground.core.model.CampLocation
import com.campground.core.model.CampSearch

interface NetworkDataSource {
    suspend fun getCampBasic(): CampResult<CampBasic>
    /*suspend fun getCampLocation(): CampResult<CampLocation>
    suspend fun getCampSearch(): CampResult<CampSearch>*/
}