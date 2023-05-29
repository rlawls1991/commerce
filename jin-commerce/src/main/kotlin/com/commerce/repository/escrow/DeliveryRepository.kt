package com.commerce.repository.escrow


import com.commerce.domain.escrow.Delivery
import org.springframework.data.jpa.repository.JpaRepository

interface DeliveryRepository : JpaRepository<Delivery, Long> {
}
