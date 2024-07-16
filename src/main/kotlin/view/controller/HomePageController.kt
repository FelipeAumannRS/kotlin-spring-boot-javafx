package view.controller

import javafx.fxml.FXML
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.VBox
import net.rgielen.fxweaver.core.FxmlView
import org.springframework.stereotype.Controller
import view.service.use_case.HomePageUseCase
import view.service.use_case.LoginUseCase

@Controller
@FxmlView("/user-interface/view/home-page/home-page.fxml")
class HomePageController(private val homePageUseCase: HomePageUseCase) {

    @FXML
    lateinit var vbox_homePageView: VBox
    @FXML
    lateinit var anchorPane_homePage: AnchorPane

    @FXML
    fun loginOnMouseClicked() {
        homePageUseCase.loadLoginView()
    }

    @FXML
    fun doLoginOnMouseClicked() {
        homePageUseCase.loadLoginView()
    }
}
