package com.wirvsvirus.solipool.moneypool.model

import java.math.BigInteger
import java.util.*

data class Moneypool(val id: UUID, val name: String, val creator: Int, val balance: BigInteger)