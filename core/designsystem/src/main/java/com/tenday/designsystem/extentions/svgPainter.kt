package com.tenday.designsystem.extentions

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import coil.size.Size

@Composable
fun svgImageLoader(path: String) = rememberAsyncImagePainter(
    model = ImageRequest.Builder(LocalContext.current)
        .data("file:///android_asset/$path") // 로드할 SVG 경로
        .decoderFactory(SvgDecoder.Factory())
        .size(Size.ORIGINAL)
        .build()
)

fun String.svgPath(): String {
    return when(this) {
        "F1-Ⅰ" -> "level/level_F1_1.svg"
        "F1-Ⅱ" -> "level/level_F1_2.svg"
        "F2-Ⅰ" -> "level/level_F2_1.svg"
        "F2-Ⅱ" -> "level/level_F2_2.svg"
        "F2-Ⅲ" -> "level/level_F2_3.svg"
        "F3-Ⅰ" -> "level/level_F3_1.svg"
        "F3-Ⅱ" -> "level/level_F3_2.svg"
        "F3-Ⅲ" -> "level/level_F3_3.svg"
        "F4-Ⅰ" -> "level/level_F4_1.svg"
        "F4-Ⅱ" -> "level/level_F4_2.svg"
        "F4-Ⅲ" -> "level/level_F4_3.svg"
        "F5" -> "level/level_F5.svg"
        "B1" -> "level/level_B1.svg"
        "B2" -> "level/level_B2.svg"
        "B3" -> "level/level_B3.svg"
        "B4" -> "level/level_B4.svg"
        "B5" -> "level/level_B5.svg"
        "B6" -> "level/level_B6.svg"
        "G1" -> "level/level_G1.svg"
        "G2" -> "level/level_G2.svg"
        "G3" -> "level/level_G3.svg"
        "G4" -> "level/level_G4.svg"
        "G5" -> "level/level_G5.svg"
        "G6" -> "level/level_G6.svg"
        "T1" -> "level/level_T1.svg"
        "T2" -> "level/level_T2.svg"
        "T3" -> "level/level_T3.svg"
        "T4" -> "level/level_T4.svg"
        "T5" -> "level/level_T5.svg"
        "T6" -> "level/level_T6.svg"
        else -> "level/level_F1_1.svg"
    }
}