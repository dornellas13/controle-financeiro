package adapters.handlers

import adapters.interceptors.AuthenticationInterceptor
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import javax.persistence.EntityNotFoundException

data class WebApiError(
    val codigo: String,
    val mensagem: String
){
}

@ControllerAdvice
class WebApiExceptionHandler : ResponseEntityExceptionHandler() {
    val logger: Logger = LogManager.getLogger(WebApiExceptionHandler::class)
    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFound(exception: EntityNotFoundException): ResponseEntity<WebApiError> {
        logger.error(exception.message)
        return ResponseEntity(WebApiError(codigo = "erro_entidade_nao_encontrada", mensagem = "A entidade nao foi encontrada " ), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(EmptyResultDataAccessException::class)
    fun handleEmptyResultDataAccessException(exception: EmptyResultDataAccessException):  ResponseEntity<WebApiError> {
        logger.error(exception.message)
        return ResponseEntity(WebApiError(codigo = "erro_entidade_nao_encontrada", mensagem = "A entidade nao foi encontrada " ), HttpStatus.NO_CONTENT)
    }

}