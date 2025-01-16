package com.tenday.core.common.enums

enum class HandsUpLevel(
    val desc: String,
    val exp: Int,
    val resPath: String,
    val group: JobFamily,
) {
    F1_I(desc = "F1-I", exp = 0, resPath = "level/level_F1_1.svg", group = JobFamily.F),
    F1_II(desc = "F1-II", exp = 13500, resPath = "level/level_F1_2.svg", group = JobFamily.F),
    F2_I(desc = "F2-I", exp = 27000, resPath = "level/level_F2_1.svg", group = JobFamily.F),
    F2_II(desc = "F2-II", exp = 39000, resPath = "level/level_F2_2.svg", group = JobFamily.F),
    F2_III(desc = "F2-III", exp = 51000, resPath = "level/level_F2_3.svg", group = JobFamily.F),
    F3_I(desc = "F3-I", exp = 63000, resPath = "level/level_F3_1.svg", group = JobFamily.F),
    F3_II(desc = "F3-II", exp = 78000, resPath = "level/level_F3_2.svg", group = JobFamily.F),
    F3_III(desc = "F3-III", exp = 93000, resPath = "level/level_F3_3.svg", group = JobFamily.F),
    F4_I(desc = "F4-I", exp = 108000, resPath = "level/level_F4_1.svg", group = JobFamily.F),
    F4_II(desc = "F4-II", exp = 126000, resPath = "level/level_F4_2.svg", group = JobFamily.F),
    F4_III(desc = "F4-III", exp = 144000, resPath = "level/level_F4_3.svg", group = JobFamily.F),
    F5(desc = "F5", exp = 162000, resPath = "level/level_F5.svg", group = JobFamily.F),
    B1(desc = "B1", exp = 0, resPath = "level/level_B1.svg", group = JobFamily.B),
    B2(desc = "B2", exp = 24000, resPath = "level/level_B2.svg", group = JobFamily.B),
    B3(desc = "B3", exp = 52000, resPath = "level/level_B3.svg", group = JobFamily.B),
    B4(desc = "B4", exp = 78000, resPath = "level/level_B4.svg", group = JobFamily.B),
    B5(desc = "B5", exp = 117000, resPath = "level/level_B5.svg", group = JobFamily.B),
    B6(desc = "B6", exp = 169000, resPath = "level/level_B6.svg", group = JobFamily.B),
    G1(desc = "G1", exp = 0, resPath = "level/level_G1.svg", group = JobFamily.G),
    G2(desc = "G2", exp = 24000, resPath = "level/level_G2.svg", group = JobFamily.G),
    G3(desc = "G3", exp = 52000, resPath = "level/level_G3.svg", group = JobFamily.G),
    G4(desc = "G4", exp = 78000, resPath = "level/level_G4.svg", group = JobFamily.G),
    G5(desc = "G5", exp = 117000, resPath = "level/level_G5.svg", group = JobFamily.G),
    G6(desc = "G6", exp = 169000, resPath = "level/level_G6.svg", group = JobFamily.G),
    T1(desc = "T1", exp = 0, resPath = "level/level_T1.svg", group = JobFamily.T),
    T2(desc = "T2", exp = 24000, resPath = "level/level_T2.svg", group = JobFamily.T),
    T3(desc = "T3", exp = 52000, resPath = "level/level_T3.svg", group = JobFamily.T),
    T4(desc = "T4", exp = 78000, resPath = "level/level_T4.svg", group = JobFamily.T),
    T5(desc = "T5", exp = 117000, resPath = "level/level_T5.svg", group = JobFamily.T),
    T6(desc = "T6", exp = 169000, resPath = "level/level_T6.svg", group = JobFamily.T),
    NULL(desc = "", exp = 0, resPath = "", group = JobFamily.NULL);

    companion object {
        fun group(level: HandsUpLevel) = HandsUpLevel.entries.filter {
            it.group == level.group
        }
        fun level(desc: String): HandsUpLevel = HandsUpLevel.entries.firstOrNull {
            it.desc == desc
        } ?: NULL
    }

}