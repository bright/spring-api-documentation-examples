package dev.bright.brightspringapidocumentationexamples

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringDocConfiguration {
    @Bean
    fun apiInfo(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Bright Sample Api")
                    .description("Bright Sample Api")
                    .version("1.0.0")
            )
    }
}
