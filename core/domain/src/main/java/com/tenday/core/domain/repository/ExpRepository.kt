package com.tenday.core.domain.repository

import com.tenday.core.model.Exp

interface ExpRepository {
    suspend fun getLastExpList(token: String, listSize: Int): List<Exp>
}