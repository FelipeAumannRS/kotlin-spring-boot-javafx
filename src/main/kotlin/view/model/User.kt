package view.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class User(
    val id: String,
    val name: String,
    val email: String,
    val password: String,
    val celNumber: String,
    val cpf: String,
    val cnpj: String?,
    val balance: Double,
)
