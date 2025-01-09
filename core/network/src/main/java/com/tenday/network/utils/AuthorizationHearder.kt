package com.tenday.network.utils

internal fun String.toHeader(): String {
    return "Bearer $this"
}