package com.mario.challenge.picpay.domain.client

import jakarta.persistence.*
import lombok.EqualsAndHashCode
import java.math.BigDecimal

@EqualsAndHashCode(of = ["id"])
@Entity(name = "users")
@Table(name = "users")
class Client(
	var firstName: String = "",
	var lastName: String = "",
	@Column(unique = true) var document: String = "",
	@Column(unique = true) var email: String = "",
	var password: String = "",
	var balance: BigDecimal = BigDecimal.ZERO,
	@Enumerated(EnumType.STRING) var userType: UserType = UserType.COMMON,
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private var id: String = ""
)