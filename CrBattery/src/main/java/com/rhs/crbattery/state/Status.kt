package com.rhs.crbattery.state

/**
 * Status enum class represents the status of the battery.
 * It contains the following properties:
 * @property CHARGING: Status charging
 * @property DISCHARGING: Status discharging
 * @property FULL: Status full
 * @property NOT_CHARGING: Status not charging
 * @property UNKNOWN: Status unknown
 */
enum class Status {
    CHARGING,
    DISCHARGING,
    FULL,
    NOT_CHARGING,
    UNKNOWN
}