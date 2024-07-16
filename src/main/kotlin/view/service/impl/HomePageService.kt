package view.service.impl

import org.springframework.stereotype.Service
import view.controller.LoginController
import view.service.use_case.HomePageUseCase
import view.service.use_case.LoadViewUseCase

@Service
class HomePageService(private val loadViewUseCase: LoadViewUseCase) : HomePageUseCase {

    override fun loadLoginView() {
        loadViewUseCase.loadView(LoginController::class.java)
    }
}