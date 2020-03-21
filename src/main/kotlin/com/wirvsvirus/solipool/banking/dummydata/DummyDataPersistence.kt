package com.wirvsvirus.solipool.banking.dummydata

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction
import java.math.BigDecimal
import java.util.*

object Accounts : IntIdTable() {
    val externalId = varchar("external_id", 128)
    val poolId = reference("pool_id", DummyPools)
    val balance = varchar("balance", 100)
}

object DummyPools : UUIDTable(columnName = "pool_id")

class DummyPoolRow(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<DummyPoolRow>(DummyPools)
}

class AccountRow(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AccountRow>(Accounts)

    var externalId by Accounts.externalId
    var poolId by DummyPoolRow referencedOn (Accounts.poolId)
    var balance by Accounts.balance
}

fun createDummyBankingTables() {
    transaction {
        addLogger(StdOutSqlLogger)
        SchemaUtils.create(DummyPools, Accounts)

        val dummyPoolId = DummyPoolRow.new { }
        AccountRow.new {
            externalId = "testId"
            poolId = dummyPoolId
            balance = BigDecimal.ZERO.toString()
        }
    }
}
