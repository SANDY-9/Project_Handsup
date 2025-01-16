package com.tenday.core.data.mapper

import com.tenday.core.common.enums.AchieveGrade
import com.tenday.core.common.enums.MissionPeriod
import com.tenday.core.model.JobMission
import com.tenday.core.model.LeaderMission
import com.tenday.core.model.MissionDetails
import com.tenday.core.model.MissionExp
import com.tenday.core.model.PersonnelMission
import com.tenday.core.model.ProjectMission
import com.tenday.network.model.JobMissionResponse
import com.tenday.network.model.LeaderMissionResponse
import com.tenday.network.model.LeaderQuestInfo
import com.tenday.network.model.PersonnelMissionResponse
import com.tenday.network.model.ProjectResponse
import com.tenday.network.model.QuestExp

internal fun LeaderMissionResponse.toLeaderMission(): LeaderMission {
    return LeaderMission(
        department = department,
        jobGroup = jobGroup,
        missionCount = questCount,
        missionList = questInfo.map { it.toMissionDetails() },
        totalExp = totalExp,
    )
}

private fun LeaderQuestInfo.toMissionDetails(): MissionDetails {
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
        endDate = range.lastOrNull(),
    )
}

internal fun JobMissionResponse.toJobMission(): JobMission {
    return JobMission(
        department = department,
        jobGroup = jobGroup,
        totalExp = totalExp,
        missionDetails = MissionDetails(
            expList = jobQuest.map { it.toMissionExp() },
            maxCondition = maxCondition,
            maxExp = maxExp,
            medianCondition = medianCondition,
            medianExp = medianExp,
            period = MissionPeriod.getPeriod(period),
            missionGoal = questGoal,
            missionName = questName,
        )
    )
}

internal fun List<ProjectResponse>.toProjectMission(): List<ProjectMission> {
    return map {
        ProjectMission(
            content = it.content,
            exp = it.exp,
            expAt = it.expAt.toDate(),
            period = it.period,
            missionName = it.questName,
        )
    }
}

internal fun List<PersonnelMissionResponse>.toPersonnelMission(): List<PersonnelMission> {
    return mapIndexed { index, it ->
        PersonnelMission(
            achieveGrade = it.achieveGrade?.run { AchieveGrade.valueOf(this) } ?: AchieveGrade.NULL,
            diff = it.diff,
            exp = it.exp,
            expAt = it.expAt?.toDate(),
            term = if(index % 2 == 0) PersonnelMission.EvaluationTerm.상반기 else PersonnelMission.EvaluationTerm.하반기
        )
    }
}