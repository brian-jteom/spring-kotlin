package com.mjhouse.study.controller

import com.mjhouse.study.config.JwtUtil
import com.mjhouse.study.dto.AuthRequest
import com.mjhouse.study.dto.RegisterRequest
import com.mjhouse.study.entity.TbUser
import com.mjhouse.study.service.CustomUserDetailsService
import com.mjhouse.study.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController @Autowired constructor(
    private val authenticationManager: AuthenticationManager,
    private val userDetailsService: CustomUserDetailsService,
    private val jwtUtil: JwtUtil,
    private val userService: UserService
) {

    @PostMapping("/login")
    @Throws(Exception::class)
    fun createAuthenticationToken(@RequestBody authRequest: AuthRequest): String {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(authRequest.username, authRequest.password)
        )

        val userDetails: UserDetails = userDetailsService.loadUserByUsername(authRequest.username)
        return jwtUtil.generateToken(userDetails)
    }

    @PostMapping("/register")
    fun registerUser(@RequestBody registerRequest: RegisterRequest): TbUser {
        return userService.registerNewUser(
            registerRequest.username,
            registerRequest.password,
            registerRequest.authority
        )
    }
}