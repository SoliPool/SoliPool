package com.wirvsvirus.solipool.banking.business

import java.math.BigDecimal
import java.util.*


interface AccountBalanceService {

    fun getBalanceForPool(poolId: UUID): BigDecimal
}
