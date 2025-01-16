package com.tenday.feature.board.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.theme.Gray200
import com.tenday.designsystem.theme.Gray600
import com.tenday.designsystem.theme.Gray800
import com.tenday.designsystem.theme.HandsUpTypography

@Composable
fun BoardDetailsContentView(
    title: String,
    date: String,
    content: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
            .padding(vertical = Dimens.margin16)
    ) {
        Text(
            modifier = modifier.fillMaxWidth().padding(horizontal = Dimens.margin20),
            text = title,
            style = HandsUpTypography.title5,
        )
        Spacer(modifier = modifier.height(Dimens.margin6))
        Text(
            modifier = modifier.padding(horizontal = Dimens.margin20),
            text = date,
            style = HandsUpTypography.body2.copy(
                fontWeight = FontWeight.Medium,
            ),
            color = Gray600,
        )
        Spacer(modifier = modifier.height(Dimens.margin16))
        HorizontalDivider(color = Gray200)
        LazyColumn(
            modifier = modifier.padding(
                horizontal = Dimens.margin20,
                vertical = Dimens.margin16,
            )
        ) {
            item {
                Text(
                    text = content,
                    style = HandsUpTypography.body2.copy(
                        fontWeight = FontWeight.Medium,
                    ),
                    color = Gray800,
                )
            }
        }
    }
}

@Preview(name = "BoardDetailsContentView")
@Composable
private fun PreviewBoardDetailsContentView() {
    BoardDetailsContentView(
        title = "물류 자동화 프로젝트 물류 자동화 프로젝트 ",
        date = "2025.01.14",
        content = """
            안녕하세요. 
            물류 자동화 프로젝트를 신설하고, 해당 프로젝트에 참여할 팀원을 모집합니다.

            [프로젝트 목표]
            1. 작업 프로세스 분석: 물류 센터 내 주요 작업들의 프로세스를 분석하고 비효율적인 부분을 개선.
            2. 자동화 도입: 자동화 기술을 통해 물류 처리 속도 향상 및 정확도를 높이며, 인적 오류를 줄임.
            3. 효율성 증대: 물류 센터 운영의 효율성을 극대화하고, 비용을 절감.

            [모집 대상]
            - 물류, IT, 엔지니어링 등 관련 분야에서 경험이 있는 직원
            - 팀워크와 협업을 통해 효율적인 결과를 도출할 수 있는 인재

            [프로젝트 주요 활동]
            - 물류 센터 내 작업 흐름 분석 및 개선 방안 도출
            - 자동화 시스템 도입 및 테스트
            - 실시간 데이터 모니터링 시스템 구축
            - 관련 부서와 협업을 통한 프로젝트 실행

            프로젝트 종료 후 성과에 따라 DO(경험치)가 지급됩니다.
            참여를 원하는 분들은 01월 23일까지 팀 리더를 통해 지원해 주세요. 감사합니다.
        """.trimIndent()
    )
}