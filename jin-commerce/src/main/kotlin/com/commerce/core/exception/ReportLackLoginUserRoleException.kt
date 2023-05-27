package com.core.exception

import com.core.ReportExceptionAbstract
import com.core.ResponseCode

class ReportLackLoginUserRoleException : ReportExceptionAbstract(ResponseCode.LACK_LOGIN_USER_ROLE)