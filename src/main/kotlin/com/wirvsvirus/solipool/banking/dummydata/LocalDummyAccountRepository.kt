package com.wirvsvirus.solipool.banking.dummydata

import com.wirvsvirus.solipool.banking.account.AccountInfoDto
import com.wirvsvirus.solipool.banking.account.ExternalAccountConnector
import com.wirvsvirus.solipool.banking.account.ExternalRequestState
import com.wirvsvirus.solipool.common.db.UserRow
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service
class LocalDummyAccountConnector : ExternalAccountConnector {

    override fun getAccountByPoolId(poolId: UUID): AccountInfoDto? {
        return transaction {
            val row = AccountRow.find { Accounts.poolId eq poolId }.firstOrNull()
            row?.let { AccountInfoDto(it.poolId.id.value, it.externalId, it.balance.toBigDecimal()) }
        }
    }

    override fun initiateDeposit(poolId: UUID, user: UserRow, amount: BigDecimal): ExternalRequestState {
        TODO("Not yet implemented")
    }

    override fun initiatePayout(poolId: UUID, user: UserRow, amount: BigDecimal): ExternalRequestState {
        TODO("Not yet implemented")
    }
}
