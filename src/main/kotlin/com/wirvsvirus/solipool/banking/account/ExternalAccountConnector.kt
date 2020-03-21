package com.wirvsvirus.solipool.banking.account

import com.wirvsvirus.solipool.common.db.User
import java.math.BigDecimal
import java.util.*

interface ExternalAccountConnector {

    fun getAccountByPoolId(poolId: UUID): AccountInfoDto?

    fun initiateDeposit(poolId: UUID, user: User, amount: BigDecimal): ExternalRequestState

    fun initiatePayout(poolId: UUID, user: User, amount: BigDecimal): ExternalRequestState
}
