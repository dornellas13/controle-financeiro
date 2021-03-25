package adapters.interceptors

import adapters.properties.ApiProperties
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import java.lang.Exception
import javax.servlet.http.HttpServletResponse

import javax.servlet.http.HttpServletRequest


@Component
class AuthenticationInterceptor(private val apiProperties: ApiProperties) : HandlerInterceptor {
    var logger: Logger = LogManager.getLogger(AuthenticationInterceptor::class)

    @Throws(Exception::class)
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val apiKeyReceived = request.getHeader("api-key")
        return if(apiKeyReceived != null) {
            return if (apiKeyReceived == apiProperties.key) {
                true
            } else {
                logger.error("Unauthorized")
                401.also { response.status = it}
                false
            }
        } else {
            logger.error("Unauthorized")
            401.also { response.status = it }
            false
        }
    }
}