package com.core.exception

import com.core.ReportExceptionAbstract
import com.core.ResponseCode

class ReportNotFoundUserException : ReportExceptionAbstract(ResponseCode.NOT_FOUND_USER)