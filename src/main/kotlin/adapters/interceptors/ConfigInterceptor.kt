package adapters.interceptors

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter


@RequiredArgsConstructor
@Component
class ConfigInterceptor(private val authenticationInterceptor: AuthenticationInterceptor,
                        private  val requestProcessingTimeInterceptor: RequestProcessingTimeInterceptor) : WebMvcConfigurerAdapter() {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(authenticationInterceptor)
        registry.addInterceptor(requestProcessingTimeInterceptor)
    }
}