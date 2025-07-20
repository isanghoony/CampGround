package com.campground.app.core.domain

import com.campground.app.core.data.repository.CampRepository
import javax.inject.Inject

class GetCampBasicInfoUseCase @Inject constructor(
    campRepository: CampRepository
) {
   /* operator fun invoke(limit: Int = 10): Flow<List<RecentSearchQuery>> =
        campRepository.getRecentSearchQueries(limit)*/
}