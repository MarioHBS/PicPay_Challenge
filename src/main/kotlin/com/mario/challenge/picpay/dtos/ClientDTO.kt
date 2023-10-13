package com.mario.challenge.picpay.dtos

import com.mario.challenge.picpay.domain.client.UserType
import java.math.BigDecimal

data class ClientDTO(
    val firstName: String,
    val lastName: String,
    val document: String,
    val balance: BigDecimal,
    val email: String,
    val password: String,
    val userType: UserType
)
