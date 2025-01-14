package com.tenday.core.data.mapper

import com.tenday.core.common.enums.AchieveGrade
import com.tenday.core.common.enums.MissionPeriod
import com.tenday.core.model.LeaderMission
import com.tenday.core.model.MissionDetails
import com.tenday.core.model.MissionExp
import com.tenday.network.model.LeaderMissionResponse
import com.tenday.network.model.QuestInfo

internal fun LeaderMissionResponse.toLeaderMissionDetails(): LeaderMission {
    return LeaderMission(
        department = department,
        jobGroup = jobGroup,
        missionCount = questCount,
        missionList = questInfo.map { it.toMissionDetails() },
        totalExp = totalExp,
    )
}

private fun QuestInfo.toMissionDetails(): MissionDetails {
    return MissionDetails(
        expList = leaderQuest.map { it.toMissionExp() },
        maxCondition = maxCondition,
        maxExp = maxExp,
        medianCondition = medianCondition,
        medianExp = medianExp,
        period = MissionPeriod.getPeriod(period),
        missionGoal = questGoal,
        missionName = questName,
    )
}

internal fun QuestExp.toMissionExp(): MissionExp {
    return MissionExp(
        achieveGrade = AchieveGrade.valueOf(achieveGrade),
        exp = exp,
        index = index,
        month = month,
        startDate = range.firstOrNull(),
        endDate = range.firstOrNull()
    )
}