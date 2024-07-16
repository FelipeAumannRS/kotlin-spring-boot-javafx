package api.adapter.`in`.web.controller

import api.adapter.`in`.web.dto.LoginRequest
import api.adapter.`in`.web.dto.SignUpRequest
import api.domain.model.User
import api.application.port.`in`.UserUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userUseCase: UserUseCase) {

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<User?> {
        val user = userUseCase.validateLogin(loginRequest.email, loginRequest.password)
        return if (user != null) ResponseEntity.ok(user) else ResponseEntity.status(401).build()
    }

    @PostMapping("/signup")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<User> {
        val user = userUseCase.createAccount(
            signUpRequest.name,
            signUpRequest.email,
            signUpRequest.password,
            signUpRequest.phoneNumber,
            signUpRequest.cpf,
            signUpRequest.cnpj
        )
        return ResponseEntity.ok(user)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        val user = userUseCase.getUserById(id)
        return if (user != null) {
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
