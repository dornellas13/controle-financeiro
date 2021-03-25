package adapters.interceptors
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Slf4j
@Component
class RequestProcessingTimeInterceptor() : HandlerInterceptor {
    var logger: Logger = LogManager.getLogger(RequestProcessingTimeInterceptor::class)

    @Throws(Exception::class)
    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse, handler: Any
    ): Boolean {
        val startTime = System.currentTimeMillis()
        logger.info(
            "Request URL::" + request.requestURL.toString()
                    + ":: Start Time=" + System.currentTimeMillis()
        )
        request.setAttribute("startTime", startTime)
        return true
    }

    @Throws(Exception::class)
    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse, handler: Any,
        modelAndView: ModelAndView?
    ) {
        logger.info(
            ("Request URL::" + request.requestURL.toString()
                    + " Sent to Handler :: Current Time=" + System.currentTimeMillis())
        )
    }

    @Throws(Exception::class)
    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse, handler: Any, ex: Exception?
    ) {
        val startTime = request.getAttribute("startTime") as Long
        logger.info(
            ("Request URL::" + request.requestURL.toString()
                    + ":: End Time=" + System.currentTimeMillis())
        )
        logger.info(
            ("Request URL::" + request.requestURL.toString()
                    + ":: Time Total=" + (System.currentTimeMillis() - startTime))
        )
    }

}