package com.campground.core.domain

import com.campground.core.data.repository.CampRepository
import javax.inject.Inject

class GetCampBasicInfoUseCase @Inject constructor(
    campRepository: CampRepository) {
   /* operator fun invoke(limit: Int = 10): Flow<List<RecentSearchQuery>> =
        campRepository.getRecentSearchQueries(limit)*/
}