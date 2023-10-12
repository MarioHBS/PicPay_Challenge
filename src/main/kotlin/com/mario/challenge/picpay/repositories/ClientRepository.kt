package com.mario.challenge.picpay.repositories

import com.mario.challenge.picpay.domain.client.Client
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ClientRepository : JpaRepository<Client, String> {
	fun findClientByDocument(document: String): Optional<Client>
	fun findClientById(id: String): Optional<Client>
}