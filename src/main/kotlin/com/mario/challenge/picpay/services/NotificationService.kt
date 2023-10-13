package com.mario.challenge.picpay.services

import com.mario.challenge.picpay.domain.client.Client
import com.mario.challenge.picpay.dtos.NotificationDTO
import com.mario.challenge.picpay.util.typeRef
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URI

@Service
class NotificationService(@Autowired private val restTemplate: RestTemplate) {
    val url = "http://o4d9z.mocklab.io/notify"
    fun sendNotification(user: Client, message: String) {
        val request = HttpEntity(NotificationDTO(user.email, message))
        val notificationResponse = restTemplate.exchange(URI.create(url), HttpMethod.POST, request, typeRef())

        if (notificationResponse.statusCode != HttpStatus.OK) {
            println("erro ao enviar uma notificação")
            throw Exception("Serviço de notificação fora do ar")
        }
    }

}