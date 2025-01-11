package com.tenday.feature.home.utils

import com.tenday.core.common.extensions.JobFamily
import com.tenday.feature.home.R


internal fun JobFamily.getBackResId(): Int {
    return when(this) {
        JobFamily.F -> R.drawable.profile_background_field
        JobFamily.B -> R.drawable.profile_background_manage
        JobFamily.G -> R.drawable.profile_background_cx
        JobFamily.T -> R.drawable.profile_background_tech
    }
}