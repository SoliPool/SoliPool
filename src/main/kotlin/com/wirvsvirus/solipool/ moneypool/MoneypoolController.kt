package com.wirvsvirus.solipool.` moneypool`

import com.wirvsvirus.solipool.` moneypool`.model.Moneypool
import com.wirvsvirus.solipool.` moneypool`.model.MoneypoolCreateModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/moneypool")
class MoneypoolController @Autowired constructor(
        private val moneypoolService: MoneypoolService) {

    @GetMapping("{id}")
    fun getMoneypool(@PathVariable id: UUID): Moneypool {
        return moneypoolService.getMoneypool(id)
    }

    @PostMapping
    fun createMoneypool(@RequestBody createModel: MoneypoolCreateModel): Moneypool {
        return moneypoolService.createMoneypool(createModel.name, createModel.creator)
    }

}