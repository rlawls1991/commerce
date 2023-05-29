package com.commerce.repository.escrow


import com.commerce.domain.escrow.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long> {
}
