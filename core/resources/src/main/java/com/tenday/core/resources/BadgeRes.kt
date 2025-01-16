package com.tenday.core.resources

import com.tenday.core.common.enums.BadgeCode

fun BadgeCode.resources(): Int {
    return when(this) {
        BadgeCode.NULL -> 0
        BadgeCode.ANNUAL_MVP_2024 -> R.drawable.badge_2024_mvp
        BadgeCode.S_GRADE_H1_H2 -> R.drawable.badge_s_grade_h1_h2
        BadgeCode.JOB_EXP_OVER_1700 -> R.drawable.badge_job_exp_over_1700
        BadgeCode.EXP_EVERY_MONTH_FOR_A_YEAR -> R.drawable.badge_exp_every_month_for_a_year
        BadgeCode.COMPANY_PROJECT_OVER_5 -> R.drawable.badge_company_project_over_5
        BadgeCode.MONTH_SPECIAL_JOB_OVER_6 -> R.drawable.badge_month_special_job_over_6
    }
}

fun BadgeCode.offResources(): Int {
    return when(this) {
        BadgeCode.NULL -> 0
        BadgeCode.ANNUAL_MVP_2024 -> R.drawable.badge_2024_mvp_off
        BadgeCode.S_GRADE_H1_H2 -> R.drawable.badge_s_grade_h1_h2_off
        BadgeCode.JOB_EXP_OVER_1700 -> R.drawable.badge_job_exp_over_1700_off
        BadgeCode.EXP_EVERY_MONTH_FOR_A_YEAR -> R.drawable.badge_exp_every_month_for_a_year_off
        BadgeCode.COMPANY_PROJECT_OVER_5 -> R.drawable.badge_company_project_over_5_off
        BadgeCode.MONTH_SPECIAL_JOB_OVER_6 -> R.drawable.badge_month_special_job_over_6_off
    }
}