package com.mario.challenge.picpay.dtos

import java.math.BigDecimal

data class TransactionDTO(val value: BigDecimal, val senderId: String, val receiverId: String)
