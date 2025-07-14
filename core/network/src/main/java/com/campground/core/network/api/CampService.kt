package com.campground.core.network.api

import com.campground.core.model.CampBasic
import com.campground.core.network.CampResult
import retrofit2.http.GET
import retrofit2.http.Query

interface CampService {
    @GET(value = "/basedList")
    suspend fun getBasedList(
        @Query("MobileOS") os: String = "AND",
        @Query("MobileApp") appName: String = "campground",
        @Query("serviceKey") serviceKey: String = "zNpViQCKKUS7WFWxKYkjnbuV7J1WAX4k8qiXZXCOb7lIi6lyDUwWxA97DGDOS9Jl2mp/+7/8KV/hsifEWiaaSA==",
        @Query("_type") type: String = "json"
    ): CampResult<CampBasic>
}