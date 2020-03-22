package com.wirvsvirus.solipool.moneypool

import com.wirvsvirus.solipool.banking.AccountBalanceService
import com.wirvsvirus.solipool.moneypool.model.Moneypool
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class MoneypoolService @Autowired constructor(
        private val accountBalanceService: AccountBalanceService,
        private val moneypoolRepository: MoneypoolRepository) {

    fun getMoneypool(id: UUID): Moneypool? {
        val moneypoolRow = moneypoolRepository.getMoneypool(id)
        val balance = accountBalanceService.getBalanceForPool(id)
        return if (moneypoolRow != null && balance != null) {
            transaction {
                Moneypool(moneypoolRow.id.value, moneypoolRow.name, moneypoolRow.creator.id.value, balance)
            }
        } else {
            return null
        }
    }

    fun createMoneypool(name: String, creator: Int): Moneypool {
        val moneypoolRow = moneypoolRepository.createMoneypool(name, creator)
        return transaction {
            Moneypool(moneypoolRow.id.value, moneypoolRow.name, moneypoolRow.creator.id.value, BigDecimal.ZERO)
        }
    }
}