package com.mario.challenge.picpay.services

import com.mario.challenge.picpay.domain.client.Client
import com.mario.challenge.picpay.domain.client.UserType
import com.mario.challenge.picpay.dtos.ClientDTO
import com.mario.challenge.picpay.repositories.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ClientService(@Autowired private val repository: ClientRepository) {
	fun validateTransaction(sender: Client, amount: BigDecimal) {
		if (sender.userType == UserType.MERCHANT)
			throw Exception("Usuário do tipo lojista não está autorizado a realizar transação")

		if (sender.balance < amount)
			throw Exception("Saldo insuficiente")
	}

	fun findClientById(id: String): Client {
		return this.repository.findClientById(id).orElseThrow { Exception("Usuário não encontrado") }
	}
	fun createClient(user: ClientDTO) = Client.from(user).also {
		this.saveClient(it)
	}

	fun findAllClients() : List<Client> = repository.findAll()

	fun saveClient(user: Client) = this.repository.save(user)
}