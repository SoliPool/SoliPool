package com.wirvsvirus.solipool.common.db

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

class DBConnection(url: String, driver: String, user: String, password: String) {

    val database: Database = Database.connect(url, driver, user, password)

}

fun setupDB() {
    val connection = DBConnection("jdbc:h2:mem:dbsolipool;DB_CLOSE_DELAY=-1", "org.h2.Driver", "solipool", "superfuckingsecret")
    transaction(connection.database) {
        addLogger(StdOutSqlLogger)
        Tables.createTables()
    }
}

// This can be deleted once we have real data
fun createTestData() {
    transaction {
        addLogger(StdOutSqlLogger)
        User.new {
            firstname = "Test"
            lastname = "Person"
        }
    }
}
