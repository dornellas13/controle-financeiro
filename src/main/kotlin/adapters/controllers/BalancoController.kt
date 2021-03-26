package adapters.controllers

import adapters.dto.BalancoDto
import adapters.dto.toBalancoDto
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import usecases.lancamentos.CalcularBalancoUseCase
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/api/balanco")
class BalancoController(private val calcularBalancoUseCase: CalcularBalancoUseCase) {
    @GetMapping()
    fun obter(@RequestParam(required = false) categoriaId: Int? = null, @RequestParam(required = false) dataInicial: String? = null, @RequestParam(required = false) dataFinal: String? = null): ResponseEntity<BalancoDto> {
        val balancoGeral = calcularBalancoUseCase.run(
            dataInicial = if(!dataInicial.isNullOrBlank()) LocalDate.parse(dataInicial) else null ,
            dataFinal =  if(!dataFinal.isNullOrBlank()) LocalDate.parse(dataFinal) else null,
            categoriaId)

        return if(balancoGeral != null) ResponseEntity.ok(balancoGeral.toBalancoDto()) else ResponseEntity(NO_CONTENT)

    }
}