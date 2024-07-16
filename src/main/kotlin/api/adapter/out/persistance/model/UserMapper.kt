package api.adapter.out.persistance.model

import api.adapter.out.persistance.entity.UserEntity
import api.domain.model.User

fun UserEntity.toDomain(): User {
    return User(
        id = id.toString(),
        password = password,
        email = email,
        cpf = cpf,
        cnpj = cnpj,
        celNumber = celNumber,
        name = name,
        balance = balance,
        transactions = listOf()
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = this.id.toLongOrNull() ?: 0L,
        password = password,
        email = email,
        cpf = cpf,
        cnpj = cnpj,
        celNumber = celNumber,
        name = name,
        balance = balance,
    )
}