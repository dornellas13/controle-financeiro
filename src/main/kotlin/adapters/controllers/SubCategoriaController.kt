package adapters.controllers
import adapters.dto.SubCategoriaDto
import adapters.dto.toCategoriaDto
import adapters.dto.toSubCategoria
import adapters.dto.toSubCategoriaDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import usecases.categorias.ObterCategoriaUseCase
import usecases.subcategorias.CriarSubCategoriaUseCase

@RestController
@RequestMapping("/api/categorias/{categoria_id}/subcategorias")
class SubCategoriaController(
    private val obterCategoriaUseCase: ObterCategoriaUseCase,
//    private val obterSubCategoriaUseCase: ObterSubCategoriaUseCase,
                             private val criarSubCategoriaUseCase: CriarSubCategoriaUseCase,
//                             private val atualizarSubCategoriaUseCase: AtualizarSubCategoriaUseCase,
//                             private val listarSubCategoriaUseCase: ListarSubCategoriaUseCase,
//                             private val excluirSubCategoriaUseCase: ExcluirSubCategoriaUseCase
                             ) {

//    @GetMapping("/{id}")
//    fun obter(@PathVariable("categoria_id") categoriaId: Int, @PathVariable("id") id: Int): ResponseEntity<SubCategoriaDto> {
//        return ResponseEntity.ok(obterSubCategoriaUseCase.run(id).toCategoriaDto())
//    }
//
//    @GetMapping()
//    fun listar(): List<ResponseEntity<SubCategoriaDto>> {
//        return listarSubCategoriaUseCase.run().map {
//            ResponseEntity.ok(it.toSubCategoriaDto())
//        }
//    }

    @PostMapping()
    fun criar(@PathVariable("categoria_id") categoriaId: Int, @RequestBody subCategoria: SubCategoriaDto ): ResponseEntity<SubCategoriaDto> {
        val categoria = obterCategoriaUseCase.run(categoriaId)
        val subCategoriaCreated = criarSubCategoriaUseCase.run(subCategoria.toSubCategoria(categoria = categoria))
        return ResponseEntity.ok(subCategoriaCreated.toSubCategoriaDto())
    }
//
//    @DeleteMapping("/{id}")
//    fun excluir(@PathVariable("categoria_id") categoriaId: Int, @PathVariable("id") id: Int): ResponseEntity.BodyBuilder {
//        excluirSubCategoriaUseCase.run(id)
//        return ResponseEntity.ok()
//    }
//
//    @PutMapping("/{id}")
//    fun atualizar(@PathVariable("categoria_id") categoriaId: Int, @PathVariable("id") id: Int, @RequestBody categoria: SubCategoriaDto): ResponseEntity<SubCategoriaDto> {
//        val subCategoriaUpdated = atualizarSubCategoriaUseCase.run(id, categoria = categoria.toCategoria()).toCategoriaDto()
//        return ResponseEntity.ok(subCategoriaUpdated)
//    }

}