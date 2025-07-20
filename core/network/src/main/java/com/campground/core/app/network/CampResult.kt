package com.campground.core.app.network

data class CampResult<T>(
    val header: Header,
    val body: Body<T>
)

data class Header(
    val resultMsg: String,
    val resultCode: String
)

data class Body<T>(
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int,
    val items: Items<T>
)

data class Items<T>(
    val item: T
)