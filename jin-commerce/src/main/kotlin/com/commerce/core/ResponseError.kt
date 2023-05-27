package com.core

data class ResponseError(
        val code: Int,
        val detail: String
)

fun ResponseError.getErrors() = mutableMapOf<String, List<ResponseError>>().also {
    it["errors"] = listOf(this)
}