package com.wirvsvirus.solipool.banking.account


sealed class ExternalRequestState

object Success : ExternalRequestState()
object Failure : ExternalRequestState()
