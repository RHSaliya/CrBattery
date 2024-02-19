package com.rhs.crbattery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

/**
 * CrBattery is a Kotlin library that provides a simple way to observe battery state changes.
 * It is based on Kotlin Coroutines Flow and can be used in Android applications.
 * It is a part of the CrBattery project which is inspired by the <a href="https://github.com/pwittchen/RxBattery">RxBattery</a> library.
 *
 * @author Rahul Saliya
 * @version 1.0
 * @since 2024-02-18
 * @see <a href="https://github.com/pwittchen/RxBattery">RxBattery</a>
 */
class CrBattery {
    companion object {
        const val UNKNOWN = -1

        private lateinit var batteryManager: BatteryManager

        fun observe(context: Context): Flow<BatteryState> = callbackFlow {
            val receiver = createBroadcastReceiver(this)
            batteryManager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
            context.registerReceiver(receiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
            awaitClose { context.unregisterReceiver(receiver) }
        }

        private fun createBroadcastReceiver(emitter: kotlinx.coroutines.channels.SendChannel<BatteryState>) =
            object : BroadcastReceiver() {
                override fun onReceive(context: Context?, intent: Intent?) {
                    if (intent == null) return

                    val status: Int = intent.getIntExtra(BatteryManager.EXTRA_STATUS, UNKNOWN)
                    val plugged: Int = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, UNKNOWN)
                    val health: Int = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, UNKNOWN)
                    val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, UNKNOWN)
                    val temperature: Int =
                        intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, UNKNOWN)
                    val voltage: Int = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, UNKNOWN)
                    val current =
                        batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW)

                    emitter.trySend(
                        BatteryState(status, plugged, health, level, temperature, voltage, current)
                    )
                }
            }
    }
}
