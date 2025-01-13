package com.tenday.core.data.repository

import com.tenday.core.data.mapper.toExpList
import com.tenday.core.domain.repository.ExpRepository
import com.tenday.core.model.Exp
import com.tenday.network.retrofit.HandsUpDataSource
import javax.inject.Inject

internal class ExpRepositoryImpl @Inject constructor(
    private val handsUpDataSource: HandsUpDataSource,
) : ExpRepository {
    override suspend fun getLastExpList(token: String): List<Exp> {
        return handsUpDataSource.getLastExpList(token).toExpList()
    }
}