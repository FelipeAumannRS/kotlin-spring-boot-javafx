package view

import javafx.application.Application
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.text.Font
import javafx.stage.Stage
import net.rgielen.fxweaver.core.FxControllerAndView
import net.rgielen.fxweaver.core.FxWeaver
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import view.controller.HomePageController

@SpringBootApplication(scanBasePackages = ["api", "view"])
@EnableJpaRepositories(basePackages = ["api.application.port.out"])
@EntityScan(basePackages = ["api.adapter.out.persistance.entity"])
open class FxApp : Application() {

    companion object {
        lateinit var applicationContext: ConfigurableApplicationContext
    }

    override fun init() {
        applicationContext = SpringApplication.run(FxApp::class.java)
    }

    override fun start(primaryStage: Stage) {
        Font.loadFont(FxApp::class.java.getResourceAsStream("/user-interface/fonts/C6SansDisplay-SemiBold.ttf"), 0.0)
        Font.loadFont(FxApp::class.java.getResourceAsStream("/user-interface/fonts/C6SansDisplay-Bold.ttf"), 0.0)
        Font.loadFont(FxApp::class.java.getResourceAsStream("/user-interface/fonts/C6SansDisplay-Medium.ttf"), 0.0)
        Font.loadFont(FxApp::class.java.getResourceAsStream("/user-interface/fonts/C6SansDisplay-Light.ttf"), 0.0)
        Font.loadFont(FxApp::class.java.getResourceAsStream("/user-interface/fonts/C6SansDisplay-Regular.ttf"), 0.0)

        val fxWeaver = applicationContext.getBean(FxWeaver::class.java)
        val controllerAndView: FxControllerAndView<HomePageController, Parent> = fxWeaver.load(HomePageController::class.java)

        val root = controllerAndView.view.get()

        val scene = Scene(root)

        primaryStage.scene = scene
        primaryStage.title = "C6 Bank"
        primaryStage.isMaximized = true
        primaryStage.icons.add(Image(javaClass.classLoader.getResource("user-interface/icons/c6.png")?.toString()))

        primaryStage.show()
    }

    override fun stop() {
        applicationContext.close()
    }
}

fun main(args: Array<String>) {
    Application.launch(FxApp::class.java, *args)
}