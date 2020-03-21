package com.wirvsvirus.solipool.common.db

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.SchemaUtils

object Tables {

    // Dummy table definition. {@link IntIdTable} automatically creates an auto-incrementing id column as primary key
    object Users : IntIdTable() {
        val firstName = this.varchar("firstname", 120)
        val lastname = this.varchar("lastname", 120)
    }

    fun createTables() {
        // All table definitions have to be added here
        SchemaUtils.create(Users)
    }

}

