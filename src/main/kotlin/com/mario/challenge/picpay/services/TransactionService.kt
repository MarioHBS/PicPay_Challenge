package com.mario.challenge.picpay.services

import com.mario.challenge.picpay.domain.client.Client
import com.mario.challenge.picpay.domain.transaction.Transactions
import com.mario.challenge.picpay.dtos.TransactionDTO
import com.mario.challenge.picpay.repositories.TransactionRepository
import com.mario.challenge.picpay.util.typeRef
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.math.BigDecimal
import java.net.URI

@Service
class TransactionService(
	@Autowired private val userService: ClientService,
	@Autowired private val repository: TransactionRepository,
	@Autowired private val restTemplate: RestTemplate
) {
	val url = "https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6"
	val validate = "Autorizado"
	fun createTransaction(transaction: TransactionDTO) {
		val sender = this.userService.findClientById(transaction.senderId)
		val receiver = this.userService.findClientById(transaction.receiverId)

		userService.validateTransaction(sender, transaction.value)
		//https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6


		if (!authorizeTransaction(sender, transaction.value)) {
			throw Exception("Transação não autorizada")
		}

		val operation = Transactions(transaction.value, sender, receiver)

		transaction.value.let {
			sender.balance -= it
			receiver.balance += it
		}
		repository.save(operation)
		userService.saveClient(sender)
		userService.saveClient(receiver)
	}

	fun authorizeTransaction(user: Client, value: BigDecimal): Boolean {
		val request = RequestEntity<Map<String, String>>(HttpMethod.GET, URI.create(url))
		val authorizationResponse = restTemplate.exchange(request, typeRef<Map<String, String>>())

		if (authorizationResponse.statusCode == HttpStatus.OK) {
			val message: String? = authorizationResponse.body!!["message"]
			return validate == message
		}
		return false
	}
}
