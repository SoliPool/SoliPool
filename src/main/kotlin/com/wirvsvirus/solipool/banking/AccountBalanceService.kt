package com.wirvsvirus.solipool.banking

import java.math.BigInteger
import java.util.*


interface AccountBalanceService {

    fun getBalanceForPool(id: UUID): BigInteger?
}
