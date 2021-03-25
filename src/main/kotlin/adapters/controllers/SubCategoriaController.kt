package adapters.controllers
import adapters.dto.*
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import usecases.lancamentos.CriarLancamentoUseCase
import usecases.subcategorias.AtualizarSubCategoriaUseCase
import usecases.subcategorias.ExcluirSubCategoriaUseCase
import usecases.subcategorias.ListarSubCategoriaUseCase
import usecases.subcategorias.ObterSubCategoriaUseCase

@RestController
@RequestMapping("/api/subcategorias")
class SubCategoriaController(private val obterSubCategoriaUseCase: ObterSubCategoriaUseCase,
                             private val atualizarSubCategoriaUseCase: AtualizarSubCategoriaUseCase,
                             private val listarSubCategoriaUseCase: ListarSubCategoriaUseCase,
                             private val excluirSubCategoriaUseCase: ExcluirSubCategoriaUseCase,
                             private val criarLancamentoUseCase: CriarLancamentoUseCase
                             ) {

    @GetMapping("/{id}")
    fun obter(@PathVariable("id") id: Int): ResponseEntity<SubCategoriaDto> {
        return ResponseEntity.ok(obterSubCategoriaUseCase.run(id).toSubCategoriaDto())
    }

    @GetMapping()
    fun listar(): ResponseEntity<List<SubCategoriaDto>> {
        return ResponseEntity.ok(listarSubCategoriaUseCase.run().map {
            it.toSubCategoriaDto()
        })
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable("id") id: Int): ResponseEntity<Any> {
        excluirSubCategoriaUseCase.run(id)
        return ResponseEntity(ACCEPTED)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable("id") id: Int, @RequestBody subCategoria: SubCategoriaDto): ResponseEntity<SubCategoriaDto> {
        val subCategoriaUpdated = atualizarSubCategoriaUseCase.run(id, subCategoria = subCategoria.toSubCategoria()).toSubCategoriaDto()
        return ResponseEntity.ok(subCategoriaUpdated)
    }


    @PostMapping("/{id}/lancamentos")
    fun criarLancamento(@PathVariable("id") id: Int, @RequestBody lancamento: LancamentoDto): ResponseEntity<LancamentoDto> {
        val subCategoria = obterSubCategoriaUseCase.run(id)
        val lancamentoCreated = criarLancamentoUseCase.run(lancamento = lancamento.toLancamento(subCategoria.toSubCategoriaDto()))
        return ResponseEntity(lancamentoCreated.toLancamentoDto(), CREATED)
    }

}