package com.rhs.crbattery.state

/**
 * Plugged enum class represents the plugged state of the battery.
 * It contains the following properties:
 * @property AC: Plugged AC
 * @property USB: Plugged USB
 * @property WIRELESS: Plugged wireless
 * @property UNKNOWN: Plugged unknown
 */
enum class Plugged {
    AC,
    USB,
    WIRELESS,
    UNKNOWN
}