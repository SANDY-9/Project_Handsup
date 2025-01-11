package com.tenday.core.common.enums

fun Int.toData(): String {
    return "%,d".format(this)
}