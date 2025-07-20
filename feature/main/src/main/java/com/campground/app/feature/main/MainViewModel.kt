package com.campground.app.feature.main

import androidx.lifecycle.ViewModel
import com.campground.app.core.router.api.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MainViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {

}