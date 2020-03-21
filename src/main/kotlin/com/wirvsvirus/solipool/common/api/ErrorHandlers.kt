package com.wirvsvirus.solipool.common.api

import com.wirvsvirus.solipool.common.api.errors.InternalServerError
import com.wirvsvirus.solipool.common.api.errors.NotFound
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorHandlers {

    @ExceptionHandler(InternalServerError::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    fun handleUnknownException(ex: Exception) = getErrorObject(HttpStatus.INTERNAL_SERVER_ERROR, ex)

    @ExceptionHandler(NotFound::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    fun handleNotFound(ex: NotFound) = getErrorObject(HttpStatus.NOT_FOUND, ex)
}

fun getErrorObject(httpStatus: HttpStatus, exception: Exception) = object {
    val code = httpStatus.value()
    val reason = httpStatus.reasonPhrase
    val error = exception.message
}
