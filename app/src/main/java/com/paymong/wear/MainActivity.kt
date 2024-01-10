package com.paymong.wear

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.paymong.wear.domain.repository.MqttRepository
import com.paymong.wear.ui.theme.PaymongTheme
import com.paymong.wear.ui.view.NavGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var mqttRepository: MqttRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PaymongTheme {
                NavGraph()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mqttRepository.connectAfterResume()
    }

    override fun onPause() {
        super.onPause()
        mqttRepository.disConnectAfterPause()
    }
}