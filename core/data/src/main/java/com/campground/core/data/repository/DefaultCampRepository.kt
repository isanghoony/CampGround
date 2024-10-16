package com.campground.core.data.repository

import com.campground.core.model.CampBasic
import com.campground.core.network.CampResult
import com.campground.core.network.NetworkDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class DefaultCampRepository @Inject constructor(
    private val network: NetworkDataSource
) : CampRepository {
    override suspend fun getCampBasic(): CampResult<CampBasic> {
        //필요하면 가공
        return network.getCampBasic()
    }
}