package com.rhs.crbattery.state

/**
 * Health enum class represents the health of the battery.
 * It contains the following properties:
 * @property COLD: Health cold
 * @property DEAD: Health dead
 * @property GOOD: Health good
 * @property OVERHEAT: Health overheated
 * @property OVER_VOLTAGE: Health over voltage
 * @property UNKNOWN: Health unknown
 * @property UNSPECIFIED_FAILURE: Health unspecified failure
 */
enum class Health {
    COLD,
    DEAD,
    GOOD,
    OVERHEAT,
    OVER_VOLTAGE,
    UNKNOWN,
    UNSPECIFIED_FAILURE
}