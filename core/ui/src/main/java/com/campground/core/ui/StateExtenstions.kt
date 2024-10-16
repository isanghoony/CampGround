package com.campground.core.ui

import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.DisposableEffectResult
import androidx.compose.runtime.DisposableEffectScope
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.platform.LocalView
import androidx.metrics.performance.PerformanceMetricsState
import androidx.metrics.performance.PerformanceMetricsState.Holder
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberMetricsStateHolder(): Holder {
    // 현재 컴포지션에서 LocalView를 가져옵니다
    val localView = LocalView.current

    // remember를 사용하여 뷰 계층 구조에 대한 Holder 객체를 생성하고 저장합니다
    // localView가 변경되지 않는 한 이 객체는 기억됩니다
    return remember(localView) {
        PerformanceMetricsState.getHolderForHierarchy(localView)
    }
}

@Composable
fun TrackDisposableJank(
    vararg keys: Any,
    reportMetric: DisposableEffectScope.(state: Holder) -> DisposableEffectResult,
) {
    // rememberMetricsStateHolder()를 호출하여 메트릭스를 가져옵니다
    val metrics = rememberMetricsStateHolder()

    // DisposableEffect를 사용하여 메트릭스를 추적합니다
    DisposableEffect(metrics, *keys) {
        reportMetric(this, metrics)
    }
}

@Composable
fun TrackScrollJank(scrollableState: ScrollableState, stateName: String) {
    // TrackJank 함수를 호출하여 스크롤 상태를 추적합니다
    TrackJank(scrollableState) { metricsHolder ->
        // 스크롤 상태가 진행 중인지에 대한 snapshotFlow를 수집합니다
        snapshotFlow { scrollableState.isScrollInProgress }.collect { isScrollInProgress ->
            metricsHolder.state?.apply {
                if (isScrollInProgress) {
                    // 스크롤이 진행 중이면 상태를 업데이트합니다
                    putState(stateName, "Scrolling=true")
                } else {
                    // 스크롤이 중지되면 상태를 제거합니다
                    removeState(stateName)
                }
            }
        }
    }
}

@Composable
fun TrackJank(
    vararg keys: Any,
    reportMetric: suspend CoroutineScope.(state: Holder) -> Unit,
) {
    // rememberMetricsStateHolder()를 호출하여 메트릭스를 가져옵니다
    val metrics = rememberMetricsStateHolder()

    // LaunchedEffect를 사용하여 메트릭스를 추적합니다
    LaunchedEffect(metrics, *keys) {
        reportMetric(metrics)
    }
}
