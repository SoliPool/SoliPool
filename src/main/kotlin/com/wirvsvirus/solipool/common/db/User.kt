package com.wirvsvirus.solipool.common.db

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

/**
 * Row representation of a user.
 * New instances are created by calling User.new { }
 */
class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(Tables.Users)

    var firstname by Tables.Users.firstName
    var lastname by Tables.Users.lastname
}
