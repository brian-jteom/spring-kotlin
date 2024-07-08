package com.mjhouse.study.service

import com.mjhouse.study.entity.TbUser
import com.mjhouse.study.repository.TbUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val userRepository: TbUserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun registerNewUser(username: String, password: String, authority: String): TbUser {
        val user = TbUser(
            username = username,
            password = passwordEncoder.encode(password),
            enabled = true,
            authority = authority
        )
        return userRepository.save(user)
    }
}