package com.wirvsvirus.solipool.banking

import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*


interface AccountBalanceService {

    fun getBalanceForPool(id: UUID): BigDecimal?
}

@Service
class AccountBalanceServiceImpl : AccountBalanceService {
    override fun getBalanceForPool(id: UUID): BigDecimal? {
        return BigDecimal.TEN
    }
}
