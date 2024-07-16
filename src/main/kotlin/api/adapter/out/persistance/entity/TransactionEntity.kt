package api.adapter.out.persistance.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "transaction")
class TransactionEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    val sender: UserEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id", nullable = false)
    val receiver: UserEntity,

    @Column(name = "amount", nullable = false)
    val amount: Double,

    @Column(name = "timestamp", nullable = false)
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    constructor() : this(
        sender = UserEntity(),
        receiver = UserEntity(),
        amount = 0.0
    )
}
