package adapters.controllers
import adapters.dto.SubCategoriaDto
import adapters.dto.toCategoriaDto
import adapters.dto.toSubCategoria
import adapters.dto.toSubCategoriaDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import usecases.categorias.ObterCategoriaUseCase
import usecases.subcategorias.*

@RestController
@RequestMapping("/api/subcategorias")
class SubCategoriaController(private val obterSubCategoriaUseCase: ObterSubCategoriaUseCase,
                             private val atualizarSubCategoriaUseCase: AtualizarSubCategoriaUseCase,
                             private val listarSubCategoriaUseCase: ListarSubCategoriaUseCase,
                             private val excluirSubCategoriaUseCase: ExcluirSubCategoriaUseCase
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
    fun excluir(@PathVariable("id") id: Int): ResponseEntity.BodyBuilder {
        excluirSubCategoriaUseCase.run(id)
        return ResponseEntity.ok()
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable("id") id: Int, @RequestBody subCategoria: SubCategoriaDto): ResponseEntity<SubCategoriaDto> {
        val subCategoriaUpdated = atualizarSubCategoriaUseCase.run(id, subCategoria = subCategoria.toSubCategoria()).toSubCategoriaDto()
        return ResponseEntity.ok(subCategoriaUpdated)
    }

}