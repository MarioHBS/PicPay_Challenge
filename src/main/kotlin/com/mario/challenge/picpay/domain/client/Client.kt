package com.mario.challenge.picpay.domain.client

import jakarta.persistence.*
import lombok.EqualsAndHashCode
import java.math.BigDecimal

@EqualsAndHashCode(of = ["id"])
@Entity(name = "users")
@Table(name = "users")
class Client(
	  var firstName: String,
	  var lastName: String,
	  @Column(name = "document", unique = true) var cpf_cnpj: String,
	  var email: String,
	  var password: String,
	  var balance: BigDecimal,
	  @Enumerated(EnumType.STRING) var userType: UserType,
	  @Id
	  @GeneratedValue(strategy = GenerationType.UUID)
	  private var id: String) {
}