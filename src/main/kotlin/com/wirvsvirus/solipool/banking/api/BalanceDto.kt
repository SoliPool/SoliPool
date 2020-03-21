package com.wirvsvirus.solipool.banking.api

import java.util.*


data class BalanceDto(val poolId: UUID, val balance: Double, val formattedBalance: String)
