package view.component

import org.springframework.stereotype.Component
import view.model.User

@Component
object SessionManager {

    private var loggedInUser: User? = null

    fun setLoggedInUser(user: User) {
        loggedInUser = user
    }

    fun getLoggedInUser(): User? {
        return loggedInUser
    }

    fun getLoggedInUserName(): String? {
        return loggedInUser?.name
    }

    fun clear() {
        loggedInUser = null
    }
}
