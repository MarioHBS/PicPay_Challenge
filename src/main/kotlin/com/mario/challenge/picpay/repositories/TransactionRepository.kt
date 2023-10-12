package com.mario.challenge.picpay.repositories

import com.mario.challenge.picpay.domain.transaction.Transactions
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository : JpaRepository<Transactions, Long> {
}