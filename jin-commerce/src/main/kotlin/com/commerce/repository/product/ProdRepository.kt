package com.commerce.repository.product


import com.commerce.domain.product.Prod
import org.springframework.data.jpa.repository.JpaRepository

interface ProdRepository : JpaRepository<Prod, Long> {
}
