package adapters.controllers

import adapters.dto.LancamentoDto
import adapters.dto.toLancamento
import adapters.dto.toLancamentoDto
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import usecases.lancamentos.AtualizarLancamentoUseCase
import usecases.lancamentos.ExcluirLancamentoUseCase
import usecases.lancamentos.ListarLancamentoUseCase
import usecases.lancamentos.ObterLancamentoUseCase

@RestController
@RequestMapping("/api/lancamentos")
class LancamentoController(private val obterLancamentoUseCase: ObterLancamentoUseCase,
                           private val atualizarLancamentoUseCase: AtualizarLancamentoUseCase,
                           private val listarLancamentoUseCase: ListarLancamentoUseCase,
                           private val excluirLancamentoUseCase: ExcluirLancamentoUseCase
) {

    @GetMapping("/{id}")
    fun obter(@PathVariable("id") id: Int): ResponseEntity<LancamentoDto> {
        return ResponseEntity.ok(obterLancamentoUseCase.run(id).toLancamentoDto())
    }

    @GetMapping()
    fun listar(): ResponseEntity<List<LancamentoDto>> {
        return ResponseEntity.ok(listarLancamentoUseCase.run().map {
            it.toLancamentoDto()
        })
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable("id") id: Int): ResponseEntity<Any> {
        excluirLancamentoUseCase.run(id)
        return ResponseEntity(OK)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable("id") id: Int, @RequestBody lancamento: LancamentoDto): ResponseEntity<LancamentoDto> {
        val lancamentoUpdated = atualizarLancamentoUseCase.run(id, lancamento = lancamento.toLancamento()).toLancamentoDto()
        return ResponseEntity.ok(lancamentoUpdated)
    }

}