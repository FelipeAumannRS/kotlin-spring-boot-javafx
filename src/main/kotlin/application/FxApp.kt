package org.example

import com.example.javafxkotlinspring.HelloController
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import net.rgielen.fxweaver.core.FxWeaver
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
open class FxApp : Application() {

    private lateinit var applicationContext: ConfigurableApplicationContext

    override fun init() {
        applicationContext = SpringApplication.run(FxApp::class.java)
    }

    override fun start(primaryStage: Stage) {
        val fxWeaver = applicationContext.getBean(FxWeaver::class.java)
        val root = fxWeaver.loadView(HelloController::class.java)

        primaryStage.scene = Scene(root)
        primaryStage.title = "JavaFX Kotlin Spring"
        primaryStage.show()
    }

    override fun stop() {
        applicationContext.close()
    }
}

fun main(args: Array<String>) {
    Application.launch(FxApp::class.java, *args)
}