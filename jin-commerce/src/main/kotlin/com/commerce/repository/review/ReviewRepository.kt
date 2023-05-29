package com.commerce.repository.review


import com.commerce.domain.review.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<Review, Long> {
}
