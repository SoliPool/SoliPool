package com.wirvsvirus.solipool.banking.business.impl

import com.wirvsvirus.solipool.banking.account.ExternalAccountConnector
import com.wirvsvirus.solipool.banking.business.AccountBalanceService
import com.wirvsvirus.solipool.common.api.errors.NotFound
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*


@Service
class AccountBalanceServiceImpl @Autowired constructor(val accountConnector: ExternalAccountConnector) : AccountBalanceService {

    override fun getBalanceForPool(poolId: UUID): BigDecimal {
        return accountConnector.getAccountByPoolId(poolId)?.balance
                ?: throw NotFound("Could not find an account for poolID $poolId.")
    }

    override fun formatToCurrency(balance: BigDecimal): String {
        return NumberFormat.getCurrencyInstance(Locale.GERMANY).format(balance.toDouble())
    }
}
