package adapters.controllers

import adapters.dto.BalancoDto
import adapters.dto.toBalancoDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import usecases.lancamentos.CalcularBalancoUseCase

@RestController
@RequestMapping("/api/balanco")
class BalancoController(private val calcularBalancoUseCase: CalcularBalancoUseCase) {
    @GetMapping()
    fun obter(@RequestParam categoriaId: Int?): ResponseEntity<BalancoDto> {
        return ResponseEntity.ok(calcularBalancoUseCase.run(dataInicial = null ,dataFinal = null, categoriaId).toBalancoDto())
    }
}