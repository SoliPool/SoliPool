package com.wirvsvirus.solipool

import com.wirvsvirus.solipool.banking.dummydata.createDummyBankingTables
import com.wirvsvirus.solipool.common.db.setupDB
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SoliPoolApplication

fun main(args: Array<String>) {
	runApplication<SoliPoolApplication>(*args)
	setupDB()
	createDummyBankingTables()
}
