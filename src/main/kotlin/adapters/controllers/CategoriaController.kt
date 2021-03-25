package adapters.controllers
import adapters.dto.*
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import usecases.categorias.*
import usecases.subcategorias.CriarSubCategoriaUseCase

@RestController
@RequestMapping("/api/categorias")
class CategoriaController(private val obterCategoriaUseCase: ObterCategoriaUseCase,
                          private val criarCategoriaUseCase: CriarCategoriaUseCase,
                          private val atualizarCategoriaUseCase: AtualizarCategoriaUseCase,
                          private val listarCategoriaUseCase: ListarCategoriaUseCase,
                          private val excluirCategoriaUseCase: ExcluirCategoriaUseCase,
                          private val criarSubCategoriaUseCase: CriarSubCategoriaUseCase
                          ) {

    @GetMapping("/{id}")
    fun obter(@PathVariable("id") id: Int): ResponseEntity<CategoriaDto> {
        return ResponseEntity.ok(obterCategoriaUseCase.run(id).toCategoriaDto())
    }

    @GetMapping()
    fun listar(): ResponseEntity<List<CategoriaDto>> {
        return ResponseEntity.ok(listarCategoriaUseCase.run().map {
            it.toCategoriaDto()
        })
    }

    @PostMapping()
    fun criar(@RequestBody categoria: CategoriaDto): ResponseEntity<CategoriaDto> {
        val categoriaCreated = criarCategoriaUseCase.run(categoria.toCategoria())
        return ResponseEntity(categoriaCreated.toCategoriaDto(), CREATED)
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable("id") id: Int): ResponseEntity<Any> {
        excluirCategoriaUseCase.run(id)
        return ResponseEntity(OK)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable("id") id: Int, @RequestBody categoria: CategoriaDto): ResponseEntity<CategoriaDto> {
       val categoriaUpdated = atualizarCategoriaUseCase.run(id, categoria = categoria.toCategoria()).toCategoriaDto()
        return ResponseEntity.ok(categoriaUpdated)
    }

    @PostMapping("/{id}/subcategorias")
    fun criarSubCategoria(@PathVariable("id") id: Int, @RequestBody subCategoria: SubCategoriaDto): ResponseEntity<SubCategoriaDto> {
        val categoria = obterCategoriaUseCase.run(id)
        val subCategoriaCreated = criarSubCategoriaUseCase.run(subCategoria.toSubCategoria(categoria = categoria))
        return ResponseEntity(subCategoriaCreated.toSubCategoriaDto(), CREATED)
    }

}