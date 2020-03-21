package com.wirvsvirus.solipool.` moneypool`

import com.wirvsvirus.solipool.` moneypool`.model.Moneypool
import org.springframework.stereotype.Service
import java.util.*

@Service
class MoneypoolService {

    fun getMoneypool(id: UUID): Moneypool {
        //TODO: get moneypool from database
        return Moneypool(id, "Moneypool", "super Creator")
    }

    fun createMoneypool(name: String, creator: String): Moneypool {
        //TODO: create moneypool in database
        return Moneypool(UUID.randomUUID(), name, creator)
    }
}