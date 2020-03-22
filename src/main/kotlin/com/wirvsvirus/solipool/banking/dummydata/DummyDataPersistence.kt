package com.wirvsvirus.solipool.banking.dummydata

import com.wirvsvirus.solipool.common.db.MoneypoolRow
import com.wirvsvirus.solipool.common.db.Tables
import com.wirvsvirus.solipool.common.db.UserRow
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction
import java.math.BigDecimal

object Accounts : IntIdTable() {
    val externalId = varchar("external_id", 128)
    val poolId = reference("pool_id", Tables.Moneypools)
    val balance = varchar("balance", 100)
}

class AccountRow(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AccountRow>(Accounts)

    var externalId by Accounts.externalId
    var poolId by MoneypoolRow referencedOn (Accounts.poolId)
    var balance by Accounts.balance
}

fun createDummyBankingTables() {
    transaction {
        addLogger(StdOutSqlLogger)
        SchemaUtils.create(Accounts)

        val testUser = UserRow.new {
            firstname = "Test"
            lastname = "User"
        }
        commit()
        val testPool = MoneypoolRow.new {
            name = "Test Pool"
            creatorId = testUser.id
        }
        commit()
        AccountRow.new {
            externalId = "testId"
            poolId = testPool
            balance = BigDecimal.ZERO.toString()
        }
    }
}
