package com.wirvsvirus.solipool.banking.account

import com.wirvsvirus.solipool.common.db.UserRow
import java.math.BigDecimal
import java.util.*

interface ExternalAccountConnector {

    fun getAccountByPoolId(poolId: UUID): AccountInfoDto?

    fun initiateDeposit(poolId: UUID, user: UserRow, amount: BigDecimal): ExternalRequestState

    fun initiatePayout(poolId: UUID, user: UserRow, amount: BigDecimal): ExternalRequestState
}
