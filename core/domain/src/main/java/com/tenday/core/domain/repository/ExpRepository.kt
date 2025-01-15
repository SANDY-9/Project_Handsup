package com.tenday.core.domain.repository

import com.tenday.core.model.ExpDetails

interface ExpRepository {
    suspend fun getLastExpList(token: String, listSize: Int): ExpDetails
    suspend fun getExpDetails(token: String): ExpDetails
}