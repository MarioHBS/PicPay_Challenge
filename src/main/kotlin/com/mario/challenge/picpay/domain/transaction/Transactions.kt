package com.mario.challenge.picpay.domain.transaction

import com.mario.challenge.picpay.domain.client.Client
import jakarta.persistence.*
import lombok.EqualsAndHashCode
import lombok.NoArgsConstructor
import java.math.BigDecimal
import java.time.LocalDateTime

@EqualsAndHashCode(of = ["id"])
@NoArgsConstructor
@Entity(name = "transactions")
@Table(name = "transactions")
class Transactions(
	private var amount: BigDecimal = BigDecimal.ZERO,
	@ManyToOne @JoinColumn(name = "sender_id") private var sender: Client = Client(),
	@ManyToOne @JoinColumn(name = "receiver_id") private var receiver: Client = Client(),
	private var timestamp: LocalDateTime = LocalDateTime.MIN,
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private val id: Long = 0L,
)