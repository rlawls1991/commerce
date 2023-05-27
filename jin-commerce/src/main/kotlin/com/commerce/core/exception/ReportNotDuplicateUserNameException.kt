package com.core.exception

import com.core.ReportExceptionAbstract
import com.core.ResponseCode

class ReportNotDuplicateUserNameException : ReportExceptionAbstract(ResponseCode.NOT_DUPLICATE_USER_NAME)