package com.mjhouse.study.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class TbUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(unique = true, nullable = false)
    val username: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = false)
    val enabled: Boolean,

    @Column(nullable = false)
    val authority: String
)