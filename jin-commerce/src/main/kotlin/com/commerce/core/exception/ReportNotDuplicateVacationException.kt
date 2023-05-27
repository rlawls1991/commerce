package com.core.exception

import com.core.ReportExceptionAbstract
import com.core.ResponseCode

class ReportNotDuplicateVacationException() : ReportExceptionAbstract(ResponseCode.NOT_DUPLICATE_VACATION) {
    constructor(response: ResponseCode) : this() {
        super.httpStatus = response.httpStatus
        super.code = response.code
        super.message = response.message
    }
}