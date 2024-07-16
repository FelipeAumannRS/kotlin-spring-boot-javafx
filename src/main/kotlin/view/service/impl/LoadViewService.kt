package view.service.impl

import javafx.scene.Parent
import net.rgielen.fxweaver.core.FxControllerAndView
import net.rgielen.fxweaver.core.FxWeaver
import org.springframework.stereotype.Service
import view.FxApp
import view.controller.HomePageController
import view.service.use_case.LoadViewUseCase

@Service
class LoadViewService(private val fxWeaver : FxWeaver) : LoadViewUseCase {

    override fun <T : Any> loadView(clazz: Class<T>) {
        val anchorPane_homePage = FxApp.applicationContext.getBean(HomePageController::class.java).anchorPane_homePage
        val controllerAndView: FxControllerAndView<T, Parent> = fxWeaver.load(clazz)
        val root = controllerAndView.view.get()
        anchorPane_homePage.children.clear()
        anchorPane_homePage.children.add(root)
        root.toFront()
    }

    override fun returnToHomePage() {
        val homePageController = FxApp.applicationContext.getBean(HomePageController::class.java)
        val anchorPane_homePage = homePageController.anchorPane_homePage
        anchorPane_homePage.children.clear()
        anchorPane_homePage.children.add(homePageController.vbox_homePageView)
    }
}