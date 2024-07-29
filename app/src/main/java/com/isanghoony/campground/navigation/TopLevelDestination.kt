/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.isanghoony.campground.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.isanghoony.feature.home.R as homeR
import com.isanghoony.feature.mypage.R as myPageR

import com.isanghoony.designsystem.icon.Icons

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
        selectedIcon = Icons.Bookmarks,
        unselectedIcon = Icons.BookmarksBorder,
        iconTextId = myPageR.string.feature_my_page_title,
        titleTextId = myPageR.string.feature_my_page_title,
    )
}
