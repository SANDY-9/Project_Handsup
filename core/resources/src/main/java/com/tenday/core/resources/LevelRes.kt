package com.tenday.core.resources

import com.tenday.core.common.enums.HandsUpLevel

fun HandsUpLevel.resources(): Int {
    return when(this) {
        HandsUpLevel.F1_I -> R.drawable.level_f1_1
        HandsUpLevel.F1_II -> R.drawable.level_f1_2
        HandsUpLevel.F2_I -> R.drawable.level_f2_1
        HandsUpLevel.F2_II -> R.drawable.level_f2_2
        HandsUpLevel.F2_III -> R.drawable.level_f2_3
        HandsUpLevel.F3_I -> R.drawable.level_f3_1
        HandsUpLevel.F3_II -> R.drawable.level_f3_2
        HandsUpLevel.F3_III -> R.drawable.level_f3_3
        HandsUpLevel.F4_I -> R.drawable.level_f4_1
        HandsUpLevel.F4_II -> R.drawable.level_f4_2
        HandsUpLevel.F4_III -> R.drawable.level_f4_3
        HandsUpLevel.F5 -> R.drawable.level_f5
        HandsUpLevel.B1 -> R.drawable.level_b1
        HandsUpLevel.B2 -> R.drawable.level_b2
        HandsUpLevel.B3 -> R.drawable.level_b3
        HandsUpLevel.B4 -> R.drawable.level_b4
        HandsUpLevel.B5 -> R.drawable.level_b5
        HandsUpLevel.B6 -> R.drawable.level_b6
        HandsUpLevel.G1 -> R.drawable.level_g1
        HandsUpLevel.G2 -> R.drawable.level_g2
        HandsUpLevel.G3 -> R.drawable.level_g3
        HandsUpLevel.G4 -> R.drawable.level_g4
        HandsUpLevel.G5 -> R.drawable.level_g5
        HandsUpLevel.G6 -> R.drawable.level_g6
        HandsUpLevel.T1 -> R.drawable.level_t1
        HandsUpLevel.T2 -> R.drawable.level_t2
        HandsUpLevel.T3 -> R.drawable.level_t3
        HandsUpLevel.T4 -> R.drawable.level_t4
        HandsUpLevel.T5 -> R.drawable.level_t5
        HandsUpLevel.T6 -> R.drawable.level_t6
        HandsUpLevel.NULL -> R.drawable.res_transparent
    }
}