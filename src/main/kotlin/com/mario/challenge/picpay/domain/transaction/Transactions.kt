package com.mario.challenge.picpay.domain.transaction

import com.mario.challenge.picpay.domain.client.Client
import jakarta.persistence.*
import lombok.EqualsAndHashCode
import java.math.BigDecimal
import java.time.LocalDateTime

@EqualsAndHashCode(of = ["id"])
@Entity(name = "transactions")
@Table(name = "transactions")
class Transactions(
	  private var amount: BigDecimal,
	  @ManyToOne @JoinColumn(name = "sender_id") private var sender: Client,
	  @ManyToOne @JoinColumn(name = "receiver_id") private var receiver: Client,
	  private var timestamp: LocalDateTime,
	  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private val id: Long,
)