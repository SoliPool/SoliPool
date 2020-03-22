package com.wirvsvirus.solipool.common.db

import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

/**
 * Row representation of a moneypool.
 * New instances are created by calling Moneypool.new { }
 */
class MoneypoolRow(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<MoneypoolRow>(Tables.Moneypools)

    var name by Tables.Moneypools.name
    var creatorId by Tables.Moneypools.creatorId
}
