package com.campground.core.network

import com.campground.core.model.CampBasic

interface NetworkDataSource {
    suspend fun getCampBasic(): CampResult<CampBasic>
    /*suspend fun getCampLocation(): CampResult<CampLocation>
    suspend fun getCampSearch(): CampResult<CampSearch>*/
}