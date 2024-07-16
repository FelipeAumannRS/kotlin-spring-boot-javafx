package api.application.service

import api.adapter.out.persistance.model.toDomain
import api.adapter.out.persistance.model.toEntity
import api.application.port.`in`.UserUseCase
import api.application.port.out.UserRepository
import api.domain.model.User
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) : UserUseCase {

    override fun validateLogin(email: String, password: String): User? {
        val userEntity = userRepository.findByEmail(email)
        val user = userEntity?.toDomain()
        return if (user?.password == password) user else null
    }

    override fun createAccount(name: String, email: String, password: String, phoneNumber: String, cpf: String, cnpj: String?): User {
        val userEntity = User(
            id = "",
            name = name,
            email = email,
            password = password,
            celNumber = phoneNumber,
            cpf = cpf,
            cnpj = cnpj,
            balance = 1_000_000.0,
            transactions = listOf()
        ).toEntity()
        return userRepository.save(userEntity).toDomain()
    }

    override fun getUserById(id: Long): User? {
        val userEntity = userRepository.findById(id).orElse(null)
        return userEntity?.toDomain()
    }
}
