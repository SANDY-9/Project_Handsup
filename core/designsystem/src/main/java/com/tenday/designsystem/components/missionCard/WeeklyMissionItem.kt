
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.core.common.enums.AchieveGrade
import com.tenday.core.model.MissionExp
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.icons.CheckMax
import com.tenday.designsystem.icons.CheckMedium
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.Gray300
import com.tenday.designsystem.theme.Gray500
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.designsystem.theme.White

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WeeklyMissionItem(
    expList: List<MissionExp>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        repeat(4) { index ->
            val item = expList.getOrNull(index + 1)
            HorizontalDivider(
                modifier = modifier.weight(1f).padding(
                    top = Dimens.margin16,
                    end = Dimens.margin12,
                ),
                color = item?.let { Gray100 } ?: Color.Transparent,
                thickness = 4.dp,
            )
        }
    }
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        repeat(5) { index ->
            val item = expList.getOrNull(index)
            Column {
                MissionGradeItem(
                    index = item?.index,
                    achieveGrade = item?.achieveGrade ?: AchieveGrade.NULL
                )
                Spacer(modifier = modifier.height(Dimens.margin6))
                MissionDateItem(
                    startDate = item?.startDate,
                    endDate = item?.endDate,
                )
            }
        }
    }
}

@Composable
private fun MissionGradeItem(
    index: Int?,
    achieveGrade: AchieveGrade,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.size(36.dp).alpha(
            alpha = if(index == null) 0.0f else 1.0f
        ),
        contentAlignment = Alignment.Center
    ) {
        HorizontalDivider(
            modifier = modifier
                .matchParentSize()
                .padding(top = Dimens.margin16),
            thickness = 4.dp,
            color = Gray100,
        )
        Box(
            modifier = modifier
                .size(36.dp)
                .background(
                    color = Gray300,
                    shape = CircleShape,
                )
        ) {
            Text(
                modifier = modifier.align(Alignment.Center),
                text = "$index",
                style = HandsUpTypography.body2.copy(
                    fontWeight = FontWeight.ExtraBold,
                    color = White,
                ),
            )
        }
        if(achieveGrade == AchieveGrade.MEDIAN) {
            Image(
                modifier = modifier.size(36.dp),
                imageVector = Icons.CheckMedium,
                contentDescription = null,
            )
        }
        if(achieveGrade == AchieveGrade.MAX) {
            Image(
                modifier = modifier.size(36.dp),
                imageVector = Icons.CheckMax,
                contentDescription = null,
            )
        }
    }
}

@Composable
private fun MissionDateItem(
    startDate: String?,
    endDate: String?,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.width(45.dp)
    ) {
        Text(
            text = startDate?.let { "$it~" } ?: "",
            style = HandsUpTypography.body3,
            color = Gray500,
        )
        Text(
            text = endDate ?: "",
            style = HandsUpTypography.body3,
            color = Gray500,
        )
    }
}

@Preview(name = "WeeklyMissionItem")
@Composable
private fun PreviewTest() {
    WeeklyMissionItem(
        listOf(
            MissionExp(
                achieveGrade = AchieveGrade.MAX,
                exp = 30,
                index = 1,
                startDate = "02.04",
                endDate = "06.09",
                month = 1
            ),
            MissionExp(
                achieveGrade = AchieveGrade.MEDIAN,
                exp = 30,
                index = 1,
                startDate = "02.04",
                endDate = "06.09",
                month = 1
            ),
            MissionExp(
                achieveGrade = AchieveGrade.MAX,
                exp = 30,
                index = 1,
                startDate = "02.04",
                endDate = "06.09",
                month = 1
            ),
            MissionExp(
                achieveGrade = AchieveGrade.NULL,
                exp = 30,
                index = 1,
                startDate = "02.04",
                endDate = "06.09",
                month = 1
            ),
            MissionExp(
                achieveGrade = AchieveGrade.NULL,
                exp = 30,
                index = 1,
                startDate = "02.04",
                endDate = "06.09",
                month = 1
            ),
        )
    )
}