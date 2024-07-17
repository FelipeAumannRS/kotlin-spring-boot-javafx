package api.adapter.out.persistance.entity

import javax.persistence.*

@Entity
@Table(name = "users")
class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0,

    @Column(name = "password", nullable = false)
    val password: String = "",

    @Column(name = "email", nullable = false)
    val email: String = "",

    @Column(name = "cpf", nullable = false)
    val cpf: String = "",

    @Column(name = "cnpj")
    val cnpj: String? = null,

    @Column(name = "cel_number", nullable = false)
    val celNumber: String = "",

    @Column(name = "name", nullable = false)
    val name: String = "",

    @Column(name = "balance")
    var balance: Double = 0.0,
) {
    constructor() : this(
        0L, "", "", "", null, "", "", 0.0
    )
}
