package com.wirvsvirus.solipool.moneypool

import com.wirvsvirus.solipool.common.db.MoneypoolRow
import com.wirvsvirus.solipool.common.db.UserRow
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service
import java.util.*

@Service
class MoneypoolRepository {

    fun createMoneypool(moneypoolName: String, creatorId: Int) : MoneypoolRow {
        return transaction {
            addLogger(StdOutSqlLogger)
            MoneypoolRow.new {
                name = moneypoolName
                creator = transaction {
                    UserRow.findById(creatorId)!!
                }
            }
        }
    }

    fun getMoneypool(id: UUID) : MoneypoolRow? {
        return transaction { MoneypoolRow.findById(id) }
    }
}