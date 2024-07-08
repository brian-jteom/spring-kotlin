package com.mjhouse.study.dto

data class RegisterRequest(
    val username: String,
    val password: String,
    val authority: String
)