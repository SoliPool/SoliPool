package com.wirvsvirus.solipool.moneypool

import com.wirvsvirus.solipool.banking.AccountBalanceService
import com.wirvsvirus.solipool.moneypool.model.Moneypool
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.BigInteger
import java.util.*

@Service
class MoneypoolService @Autowired constructor(
        private val accountBalanceService: AccountBalanceService,
        private val moneypoolRepository: MoneypoolRepository) {

    fun getMoneypool(id: UUID): Moneypool? {
        val moneypoolRow = moneypoolRepository.getMoneypool(id)
        val balance = accountBalanceService.getBalanceForPool(id) ?: BigDecimal.ZERO
        return if (moneypoolRow != null && balance != null) {
            Moneypool(moneypoolRow.id.value, moneypoolRow.name, 1, balance)
        } else {
            return null
        }
    }

    fun createMoneypool(name: String, creator: Int): Moneypool {
        val moneypoolRow = moneypoolRepository.createMoneypool(name, creator)
        return Moneypool(moneypoolRow.id.value, moneypoolRow.name, creator, BigDecimal.ZERO)
    }
}