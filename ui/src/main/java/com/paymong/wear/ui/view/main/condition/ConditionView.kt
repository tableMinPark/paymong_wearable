package com.paymong.wear.ui.view.main.condition

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import com.paymong.wear.ui.R
import com.paymong.wear.ui.theme.PaymongBlue
import com.paymong.wear.ui.theme.PaymongGreen
import com.paymong.wear.ui.theme.PaymongPink
import com.paymong.wear.ui.theme.PaymongYellow

const val imageSize = 25
const val circularSize = 60
const val strokeWidth = 4

@Composable
fun ConditionView(
    health: State<Float>,
    satiety: State<Float>,
    strength: State<Float>,
    sleep: State<Float>
) {
    /** Content **/
    ConditionContent(
        health = health,
        satiety = satiety,
        strength = strength,
        sleep = sleep
    )
}

@Composable
fun ConditionContent(
    health: State<Float>,
    satiety: State<Float>,
    strength: State<Float>,
    sleep: State<Float>
) {
    Box(
        modifier = Modifier
            .zIndex(0f)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                ConditionButton(
                    resourceId = R.drawable.health,
                    progress = health,
                    indicatorColor = PaymongPink
                )
                ConditionButton(
                    resourceId = R.drawable.satiety,
                    progress = satiety,
                    indicatorColor = PaymongYellow
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                ConditionButton(
                    resourceId = R.drawable.strength,
                    progress = strength,
                    indicatorColor = PaymongGreen
                )
                ConditionButton(
                    resourceId = R.drawable.sleep,
                    progress = sleep,
                    indicatorColor = PaymongBlue
                )
            }
        }
    }
}
