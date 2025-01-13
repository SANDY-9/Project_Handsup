package com.tenday.core.data.repository

import com.tenday.core.data.mapper.toExpDetails
import com.tenday.core.data.mapper.toExpMap
import com.tenday.core.domain.repository.ExpRepository
import com.tenday.core.model.Exp
import com.tenday.core.model.ExpDetails
import com.tenday.network.retrofit.HandsUpDataSource
import javax.inject.Inject

internal class ExpRepositoryImpl @Inject constructor(
    private val handsUpDataSource: HandsUpDataSource,
) : ExpRepository {
    override suspend fun getLastExpList(token: String, listSize: Int,): Map<Int, List<Exp>> {
        return handsUpDataSource.getLastExpList(token, listSize).toExpMap()
    }

    override suspend fun getExpDetails(token: String): ExpDetails {
        return handsUpDataSource.getExpDetails(token).toExpDetails()
    }
}

