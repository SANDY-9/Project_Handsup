package com.tenday.core.common.extentions

fun Int.toData(): String {
    return "%,d".format(this)
}