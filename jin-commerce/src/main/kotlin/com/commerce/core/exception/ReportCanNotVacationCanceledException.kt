package com.core.exception

import com.core.ReportExceptionAbstract
import com.core.ResponseCode

class ReportCanNotVacationCanceledException() : ReportExceptionAbstract(ResponseCode.CAN_NOT_VACATION_CANCEL_OVER_STARTDT) {
    
    constructor(response: ResponseCode) : this() {
        super.httpStatus = response.httpStatus
        super.code = response.code
        super.message = response.message
    }
}