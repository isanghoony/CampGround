package com.isanghoony.campground.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.isanghoony.campground.navigation.CampGroundNavHost
import com.isanghoony.campground.navigation.TopLevelDestination
import com.isanghoony.designsystem.component.NavigationBarItem
import com.isanghoony.designsystem.theme.GREY05
import com.isanghoony.designsystem.theme.GREY06

@Composable
fun CampGroundApp(appState: CampGroundState = rememberCampGroundState()) {
    Scaffold(
        modifier = Modifier.fillMaxSize(), // 화면 전체 크기로 채움
        containerColor = Color.Black, // 배경 색상 검정
        contentWindowInsets = WindowInsets(0, 0, 0, 0), // 창 삽입값 설정
        bottomBar = {
            BottomBar(
                destinations = appState.topDestinations, // 상단 목적지 리스트
                onNavigateToDestination = appState::navigateToTopDestination, // 목적지로 이동하는 함수
                currentDestination = appState.currentDestination, // 현재 선택된 목적지
                modifier = Modifier.testTag("BottomBar") // 테스트 태그 설정
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it) // 패딩 적용
                .consumeWindowInsets(it) // 창 삽입값 소비
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal) // 수평 안전 영역 삽입값
                )
        ) {
            CampGroundNavHost(
                campGroundState = appState,
                modifier = Modifier.fillMaxSize() // 화면 전체 크기로 채움
            )
        }
    }
}

@Composable
private fun BottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth() // 가로 전체 길이로 채움
                .height(1.dp) // 높이 1dp
                .background(GREY05) // 배경 색상 GREY05
        )

        NavigationBar(containerColor = GREY06) { // 내비게이션 바 배경 색상 GREY06
            destinations.forEach { destination ->
                val selected = currentDestination.isTopDestinationInHierarchy(destination) // 선택된 목적지인지 확인
                NavigationBarItem(
                    selected = selected, // 선택 상태
                    onClick = { onNavigateToDestination(destination) }, // 클릭 시 목적지로 이동
                    icon = {
                        Icon(
                            imageVector = destination.unselectedIcon, // 미선택 아이콘
                            contentDescription = "미선택 아이콘",
                        )
                    },
                    selectedIcon = {
                        Icon(
                            imageVector = destination.selectedIcon, // 선택 아이콘
                            contentDescription = "선택 아이콘",
                        )
                    },
                    label = { Text(stringResource(destination.iconTextId)) } // 아이콘 텍스트
                )
            }
        }
    }
}

private fun NavDestination?.isTopDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false // 목적지 이름 포함 여부 확인
    } ?: false
