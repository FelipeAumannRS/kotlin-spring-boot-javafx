package api.application.port.`in`

import api.domain.model.User

interface UserUseCase {

    fun validateLogin(email: String, password: String): User?
    fun createAccount(name: String, email: String, password: String, phoneNumber: String, cpf: String, cnpj: String?): User
    fun getUserById(id: Long): User?
}
