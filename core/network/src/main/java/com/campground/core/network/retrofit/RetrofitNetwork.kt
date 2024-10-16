package com.campground.core.network.retrofit

import androidx.tracing.trace
import com.campground.core.model.CampBasic
import com.campground.core.network.CampResult
import com.campground.core.network.NetworkDataSource
import com.campground.core.network.api.CampService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

//private const val BASE_URL = BuildConfig.API_BASE_URL

@Singleton
internal class RetrofitNetwork @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: dagger.Lazy<Call.Factory>,
) : NetworkDataSource {

    private val networkApi = trace("RetrofitNetwork") {
        Retrofit.Builder()
            .baseUrl("http://apis.data.go.kr/B551011/GoCamping")
            .callFactory { okhttpCallFactory.get().newCall(it) }
            .addConverterFactory(
                networkJson.asConverterFactory("application/json".toMediaType()),
            )
            .build()
            .create(CampService::class.java)
    }

    override suspend fun getCampBasic(): CampResult<CampBasic> = networkApi.getBasedList()

    /*override suspend fun getCampLocation(): CampResult<CampLocation> {

    }

    override suspend fun getCampSearch(): CampResult<CampSearch> {

    }*/
}
