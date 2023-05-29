package com.commerce.domain.escrow

enum class DeliveryStatus(val status: String) {
    A("배송중"),
    D("배송대기"),
    E("배송완료")
}