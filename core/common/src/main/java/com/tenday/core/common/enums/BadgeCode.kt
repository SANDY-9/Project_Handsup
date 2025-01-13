package com.tenday.core.common.enums

private const val resPath = "badge/"
enum class BadgeCode(
    val badgeName: String = "",
    val desc: String = "",
    val resFilePath: String = "",
    val offResFilePath: String = "",
) {
    NULL,
    ANNUAL_MVP_2024(
        badgeName = "2024 MVP",
        desc = "일년간 직원들중 가장 많은 두둥 경험치를\n획득한 단 한 명의 직원에게 부여되는 뱃지",
        resFilePath = resPath + "2024_MVP.svg",
        offResFilePath = resPath + "2024_MVP_off.svg",
    ),
    S_GRADE_H1_H2(
        badgeName = "빛나는 인재상",
        desc = "인사평가에서 S의 우수한 등급을 받아\n뛰어난 역량을 보여준 직원에게 부여되는 뱃지",
        resFilePath = resPath + "빛나는_인재상.svg",
        offResFilePath = resPath + "빛나는_인재상_off.svg",
    ),
    JOB_EXP_OVER_1700(
        badgeName = "찰떡 콜라보",
        desc = "직무미션에서 생산성 달성을 목표로 찰떡같은\n협업능력을 보여준 직원에게 부여되는 뱃지",
        resFilePath = resPath + "찰떡_콜라보.svg",
        offResFilePath = resPath + "찰떡_콜라보_off.svg",
    ),
    EXP_EVERY_MONTH_FOR_A_YEAR(
        badgeName = "월라운더",
        desc = "매달 꾸준히 월간 미션을 달성하여 모든 달의\n경험치를 획득한 올라운더 직원에게 부여되는 뱃지",
        resFilePath = resPath + "월라운더.svg",
        offResFilePath = resPath + "월라운더_off.svg",
    ),
    COMPANY_PROJECT_OVER_5(
        badgeName = "혁신의 주역",
        desc = "전사 프로젝트에서 탁월한 성과를 보여주며\n기업과 함께 성장한 직원에게 부여되는 뱃지",
        resFilePath = resPath + "혁신의_주역.svg",
        offResFilePath = resPath + "혁신의_주역_off.svg",
    ),
    MONTH_SPECIAL_JOB_OVER_6(
        badgeName = "열정의 불꽃",
        desc = "월특근 미션을 통해 열정을 뜨겁게 \n불태운 직원에게 부여되는 뱃지",
        resFilePath = resPath + "열정의_불꽃.svg",
        offResFilePath = resPath + "열정의_불꽃_off.svg",
    );
}
