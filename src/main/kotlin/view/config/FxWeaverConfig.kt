package view.config

import net.rgielen.fxweaver.core.FxWeaver
import net.rgielen.fxweaver.spring.SpringFxWeaver
import org.springframework.context.ApplicationContext
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
open class FxWeaverConfig {

    @Bean
    @Scope("singleton")
    open fun fxWeaver(applicationContext: ApplicationContext): FxWeaver {
        return SpringFxWeaver(applicationContext as ConfigurableApplicationContext)
    }
}