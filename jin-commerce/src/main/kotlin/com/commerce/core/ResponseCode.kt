package com.core

import org.springframework.http.HttpStatus

enum class ResponseCode(val httpStatus: HttpStatus, val code: Int, val message: String) {

    REQUIRE_LOGIN(HttpStatus.BAD_REQUEST, 6202, "로그인이 필요합니다."),
    NOT_FOUND_USER(HttpStatus.BAD_REQUEST, 1001, "유저를 찾을 수 없습니다."),
    LACK_REMAINING_VACATION_DAY(HttpStatus.BAD_REQUEST, 1002, "남은 휴가일수가 부족합니다."),
    NOT_STARTDT_IS_BEFORE_ENDDT(HttpStatus.BAD_REQUEST, 1003, "휴가 시작일시는 휴가 종료일시보다 같거나 전이어야 합니다."),
    NOT_VALID_DAYS_USED(HttpStatus.BAD_REQUEST, 1004, "사용휴가 일수를 확인해주세요"),
    CAN_NOT_VACATION_CANCEL_OVER_STARTDT(HttpStatus.BAD_REQUEST, 1005, "휴가시작일을 넘어서 휴가를 취소할 수 없습니다."),
    NOT_DUPLICATE_VACATION(HttpStatus.BAD_REQUEST, 1006, "휴가를 중복으로 신청할 수 없습니다."),
    NOT_DUPLICATE_VACATION_HALF(HttpStatus.BAD_REQUEST, 1007, "하루에 반차/반반차를 합쳐서 1일 넘게 신청할 수 없습니다."),
    CAN_NOT_VACATION_CANCELED_AND_APPROVAL_AND_REJECT(HttpStatus.BAD_REQUEST, 1008, "휴가를 반려/승인/취소할 수 없습니다. 문서상태를 확인해주세요"),
    NOT_DUPLICATE_USER_NAME(HttpStatus.BAD_REQUEST, 1009, "유저이름을 중복으로 생성할 수 없습니다."),
    HAVE_NOT_REQUIRE_PARAMETER(HttpStatus.BAD_REQUEST, 1010, "필수값이 빠져 있습니다."),
    CANCEL_IS_MINE(HttpStatus.BAD_REQUEST, 1012, "자신이 신청한 기안만 취소가 가능합니다."),
    LACK_LOGIN_USER_ROLE(HttpStatus.BAD_REQUEST, 1013, "로그인 계정의 권한이 부족합니다."),
    REJECT_ONLY_ADMIN(HttpStatus.BAD_REQUEST, 1014, "휴가 반려는 Admin 사용자만 가능합니다."),
    NOT_VALID_VACATION_STATUS(HttpStatus.BAD_REQUEST, 1015, "휴가 승인/반려/취소 파라미터를 확인해주세요"),
}