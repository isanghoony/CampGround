package com.campground.core.app.network

import com.campground.app.core.model.CampBasic

interface NetworkDataSource {
    suspend fun getCampBasic(): CampResult<CampBasic>
    /*suspend fun getCampLocation(): CampResult<CampLocation>
    suspend fun getCampSearch(): CampResult<CampSearch>*/
}