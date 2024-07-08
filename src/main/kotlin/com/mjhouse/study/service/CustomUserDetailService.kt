package com.mjhouse.study.service

import com.mjhouse.study.entity.TbUser
import com.mjhouse.study.repository.TbUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomUserDetailsService @Autowired constructor(
    private val userRepository: TbUserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user: TbUser = userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("User not found")

        return User(
            user.username, user.password,
            user.enabled, true, true, true,
            Collections.singletonList(SimpleGrantedAuthority(user.authority))
        )
    }
}