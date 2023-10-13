package com.mario.challenge.picpay.controllers

import com.mario.challenge.picpay.domain.client.Client
import com.mario.challenge.picpay.dtos.ClientDTO
import com.mario.challenge.picpay.services.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/users")
class ClientController() {
    @Autowired
    private lateinit var userService: ClientService

    @PostMapping
    fun createUser(user: ClientDTO): ResponseEntity<Client> {
        val newClient = userService.createClient(user)
        return ResponseEntity(newClient, HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<Client>> {
        val list = userService.findAllClients()
        return ResponseEntity.ok(list)
    }
}