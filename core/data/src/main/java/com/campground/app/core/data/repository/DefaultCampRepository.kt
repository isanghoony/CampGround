package com.campground.app.core.data.repository

import com.campground.app.core.model.CampBasic
import com.campground.core.app.network.CampResult
import com.campground.core.app.network.NetworkDataSource
import javax.inject.Inject

internal class DefaultCampRepository @Inject constructor(
    private val network: NetworkDataSource
) : CampRepository {
    override suspend fun getCampBasic(): CampResult<CampBasic> {
        //필요하면 가공
        return network.getCampBasic()
    }
}