package com.mjhouse.study.repository

import com.mjhouse.study.entity.TbUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface TbUserRepository : JpaRepository<TbUser, Long> {
    fun findByUsername(username: String): TbUser?
}