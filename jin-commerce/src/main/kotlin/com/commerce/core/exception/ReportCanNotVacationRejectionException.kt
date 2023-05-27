package com.core.exception

import com.core.ReportExceptionAbstract
import com.core.ResponseCode

class ReportCanNotVacationRejectionException : ReportExceptionAbstract(ResponseCode.REJECT_ONLY_ADMIN)