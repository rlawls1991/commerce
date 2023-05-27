package com.core.exception

import com.core.ReportExceptionAbstract
import com.core.ResponseCode

class ReportRequireLoginException() : ReportExceptionAbstract(ResponseCode.REQUIRE_LOGIN) {

    constructor(message: String) : this() {
        super.message = message
    }
}