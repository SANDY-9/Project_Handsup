package com.tenday.core.domain.repository

import com.tenday.core.model.Exp
import com.tenday.core.model.ExpDetails

interface ExpRepository {
    suspend fun getLastExpList(token: String, listSize: Int): List<Exp>
    suspend fun getExpDetails(token: String): ExpDetails
}