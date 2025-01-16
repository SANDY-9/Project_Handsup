package com.tenday.feature.exp.levelguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tenday.core.common.enums.HandsUpLevel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class LevelGuideActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val level = intent.getStringExtra(LEVEL) ?: ""
        val myLevel = HandsUpLevel.level(level)
        enableEdgeToEdge()
        setContent {
            LevelGuideScreen(
                myLevel = myLevel,
                onClose = this::finish,
            )
        }
    }

    companion object {
        const val LEVEL = "level"
    }
}