package com.core

import com.core.exception.ReportHaveNotRequireParameterException
import com.core.exception.ReportRequireLoginException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.ServletRequestBindingException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(value = [IllegalArgumentException::class])
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleIllegalArgumentException(ex: IllegalArgumentException, request: WebRequest): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(ex.message ?: "Invalid input", (ex as ReportExceptionAbstract).code), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [RuntimeException::class])
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleRuntimeException(ex: RuntimeException, request: WebRequest): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(ex.message ?: "An unexpected error occurred", (ex as ReportExceptionAbstract).code), HttpStatus.INTERNAL_SERVER_ERROR)
    }


    @ExceptionHandler(ServletRequestBindingException::class)
    fun handleException(req: HttpServletRequest, ex: ServletRequestBindingException) =
        if (ex.localizedMessage.contains("Authorization")) {
            getResponseEntity(ReportRequireLoginException())
        } else {
            getResponseEntity(ReportHaveNotRequireParameterException())
        }

    private fun getResponseEntity(ex: ReportExceptionAbstract) =
        ResponseEntity(
            ResponseError(
                code = ex.code,
                detail = ex.message
            ).getErrors(),
            getJsonHeader(),
            ex.httpStatus
        )

    private fun getJsonHeader(): HttpHeaders {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON_UTF8
        return headers
    }
}


data class ErrorResponse(val message: String, val code: Int)

abstract class ReportExceptionAbstract(
    response: ResponseCode
) : RuntimeException() {
    var httpStatus: HttpStatus = response.httpStatus
    var code: Int = response.code
    override var message: String = response.message
}