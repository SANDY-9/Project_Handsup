package com.tenday.feature.exp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tenday.designsystem.components.HandsUpShadowCard
import com.tenday.designsystem.dimens.Dimens
import com.tenday.designsystem.extentions.noRippleClickable
import com.tenday.designsystem.icons.Selected
import com.tenday.designsystem.theme.Gray100
import com.tenday.designsystem.theme.Gray900
import com.tenday.designsystem.theme.HandsUpOrange
import com.tenday.designsystem.theme.HandsUpTypography
import com.tenday.feature.exp.model.ExpCategory

@Composable
internal fun MyExpCategoryListMenu(
    categoryEntry: List<ExpCategory>,
    selectedCategory: ExpCategory,
    onSelectCategory: (ExpCategory) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.padding(
            top = 58.dp,
            end = Dimens.margin20,
        ).width(123.dp),
    ) {
        HandsUpShadowCard(
            cornerSize = Dimens.cornerShape8,
            elevationSize = 12.dp,
            content = {
                categoryEntry.forEachIndexed { index, category ->
                    CategoryItem(
                        category = category,
                        selected = selectedCategory == category,
                        visibleDivider = index < categoryEntry.lastIndex,
                        onSelect = { onSelectCategory(category) },
                    )
                }
            }
        )
    }
}

@Composable
private fun CategoryItem(
    category: ExpCategory,
    selected: Boolean,
    visibleDivider: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .noRippleClickable(onClick = onSelect)
            .padding(
                start = Dimens.margin12,
                end = Dimens.margin12,
            )
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = modifier.padding(vertical = Dimens.margin12),
                text = category.desc,
                style = HandsUpTypography.body2.copy(
                    fontWeight = FontWeight.Medium,
                    color = if(selected) HandsUpOrange else Gray900,
                ),
            )
            Spacer(modifier = modifier.weight(1f))
            if(selected) {
                Icon(
                    modifier = modifier.size(20.dp),
                    imageVector = Icons.Selected,
                    contentDescription = null,
                    tint = HandsUpOrange,
                )
            }
        }
        if(visibleDivider) {
            HorizontalDivider(color = Gray100)
        }
    }

}

@Preview(name = "MyExpCategoryListMenu")
@Composable
private fun PreviewMyExpCategoryListMenu() {
    Box(
        modifier = Modifier.padding(10.dp).width(150.dp)
    ) {
        MyExpCategoryListMenu(
            ExpCategory.entries,
            selectedCategory = ExpCategory.전체보기,
            {},
        )
        CategoryItem(
            category = ExpCategory.전체보기,
            selected = true,
            visibleDivider = true,
            onSelect = {}
        )
    }
}