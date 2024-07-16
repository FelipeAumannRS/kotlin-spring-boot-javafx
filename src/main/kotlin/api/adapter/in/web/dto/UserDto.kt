package api.adapter.`in`.web.dto

data class LoginRequest(val email: String, val password: String)
data class SignUpRequest(
    val name: String,
    val email: String,
    val password: String,
    val phoneNumber: String,
    val cpf: String,
    val cnpj: String?
)