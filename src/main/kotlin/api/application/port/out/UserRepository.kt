package api.application.port.out

import api.adapter.out.persistance.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findByName(name: String): UserEntity?
    fun findByEmail(email: String): UserEntity?
}