package com.isanghoony.campground.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.isanghoony.designsystem.icon.Icons
import com.isanghoony.feature.home.R as homeR
import com.isanghoony.feature.mypage.R as myPageR

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    HOME(
        selectedIcon = Icons.Upcoming,
        unselectedIcon = Icons.UpcomingBorder,
        iconTextId = homeR.string.feature_home_title,
        titleTextId = homeR.string.feature_home_title,
    ),
    MY_PAGE(
        selectedIcon = Icons.Settings,
        unselectedIcon = Icons.Settings,
        iconTextId = myPageR.string.feature_my_page_title,
        titleTextId = myPageR.string.feature_my_page_title,
    )
}