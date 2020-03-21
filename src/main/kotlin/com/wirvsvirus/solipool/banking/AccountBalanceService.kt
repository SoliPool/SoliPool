package com.wirvsvirus.solipool.banking

import org.springframework.stereotype.Service
import java.math.BigInteger
import java.util.*


interface AccountBalanceService {

    fun getBalanceForPool(id: UUID): BigInteger?
}

@Service
class AccountBalanceServiceImpl : AccountBalanceService {
    override fun getBalanceForPool(id: UUID): BigInteger? {
        return BigInteger.TWO
    }
}
