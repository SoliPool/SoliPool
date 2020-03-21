package com.wirvsvirus.solipool.banking.account

import java.math.BigDecimal
import java.util.*

data class AccountInfoDto(val poolId: UUID, val externalId: String, val balance: BigDecimal)
