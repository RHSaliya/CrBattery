package com.rhs.crbattery

import android.os.BatteryManager
import com.rhs.crbattery.state.Health
import com.rhs.crbattery.state.Plugged
import com.rhs.crbattery.state.Status

/**
 * BatteryState class represents the state of the battery.
 * It contains the following properties:
 * @property statusCode: Int status code of the battery
 * @property pluggedCode: Int plugged code of the battery
 * @property healthCode: Int health code of the battery
 * @property level: Int level of the battery
 * @property temperature: Int temperature of the battery
 * @property voltage: Int voltage of the battery
 * @property current: Int current of the battery
 *
 * It also contains the following methods:
 * @method status: Status returns the status of the battery
 * @method plugged: Plugged returns the plugged state of the battery
 * @method health: Health returns the health of the battery
 *
 * @constructor Creates a new BatteryState object
 */
data class BatteryState(
    val statusCode: Int,
    val pluggedCode: Int,
    val healthCode: Int,
    val level: Int,
    val temperature: Int,
    val voltage: Int,
    val current: Int
) {

    /**
     * This method returns status of the battery. It maps the battery status code to the Status enum of the library.
     *
     * @return Status: current status of the battery
     */
    fun status(): Status {
        return when (statusCode) {
            BatteryManager.BATTERY_STATUS_CHARGING -> Status.CHARGING
            BatteryManager.BATTERY_STATUS_DISCHARGING -> Status.DISCHARGING
            BatteryManager.BATTERY_STATUS_FULL -> Status.FULL
            BatteryManager.BATTERY_STATUS_NOT_CHARGING -> Status.NOT_CHARGING
            else -> Status.UNKNOWN
        }
    }

    /**
     * This method returns plugged state of the battery. It maps the plugged code to the plugged state of the battery.
     *
     * @return Plugged: current plugged state of the battery
     */
    fun plugged(): Plugged {
        return when (pluggedCode) {
            BatteryManager.BATTERY_PLUGGED_AC -> Plugged.AC
            BatteryManager.BATTERY_PLUGGED_USB -> Plugged.USB
            BatteryManager.BATTERY_PLUGGED_WIRELESS -> Plugged.WIRELESS
            else -> Plugged.UNKNOWN
        }
    }

    /**
     * This method returns health of the battery. It maps the health code to the Health enum of the library.
     *
     * @return Health: current health of the battery
     */
    fun health(): Health {
        return when (healthCode) {
            BatteryManager.BATTERY_HEALTH_COLD -> Health.COLD
            BatteryManager.BATTERY_HEALTH_DEAD -> Health.DEAD
            BatteryManager.BATTERY_HEALTH_GOOD -> Health.GOOD
            BatteryManager.BATTERY_HEALTH_OVERHEAT -> Health.OVERHEAT
            BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE -> Health.OVER_VOLTAGE
            BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE -> Health.UNSPECIFIED_FAILURE
            else -> Health.UNKNOWN
        }
    }
}