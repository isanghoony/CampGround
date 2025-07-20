package com.campground.app.feature.main

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MainUnitTest {
    @Test
    @DisplayName("덧셈이 정상적으로 동작해야 한다")
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}