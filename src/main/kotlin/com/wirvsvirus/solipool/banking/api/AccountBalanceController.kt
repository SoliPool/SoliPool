package com.wirvsvirus.solipool.banking.api

import com.wirvsvirus.solipool.banking.business.AccountBalanceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/api/balance")
class AccountBalanceController @Autowired constructor(val balanceService: AccountBalanceService) {


    @GetMapping("{poolId}")
    @ResponseBody
    fun getAvailableFunds(@PathVariable poolId: UUID): BalanceDto {
        return with(balanceService.getBalanceForPool(poolId)) {
            BalanceDto(poolId, this.toDouble(), balanceService.formatToCurrency(this))
        }
    }
}
