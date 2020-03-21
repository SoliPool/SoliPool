package com.wirvsvirus.solipool.common.api.errors

sealed class InternalServerError(message: String?) : Exception(message ?: "")

class NotFound(message: String? = null) : InternalServerError(message)

