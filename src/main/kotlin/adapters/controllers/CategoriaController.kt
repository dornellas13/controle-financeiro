package adapters.controllers
import adapters.dto.CategoriaDto
import adapters.dto.toCategoria
import adapters.dto.toCategoriaDto
import adapters.entities.CategoriaEntity
import adapters.entities.toCategoria
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import usecases.categorias.*
import usecases.repositories.ICategoriaRepository
import java.util.*

@RestController
@RequestMapping("/api/categorias")
class CategoriaController(private val obterCategoriaUseCase: ObterCategoriaUseCase,
                          private val criarCategoriaUseCase: CriarCategoriaUseCase,
                          private val atualizarCategoriaUseCase: AtualizarCategoriaUseCase,
                          private val listarCategoriaUseCase: ListarCategoriaUseCase,
                          private val excluirCategoriaUseCase: ExcluirCategoriaUseCase) {

    @GetMapping("/{id}")
    fun obter(@PathVariable("id") id: Int): ResponseEntity<CategoriaDto> {
        return ResponseEntity.ok(obterCategoriaUseCase.run(id).toCategoriaDto())
    }

    @GetMapping()
    fun listar(): List<ResponseEntity<CategoriaDto>> {
        return listarCategoriaUseCase.run().map {
            ResponseEntity.ok(it.toCategoriaDto())
        }
    }

    @PostMapping()
    fun criar(@RequestBody categoria: CategoriaDto): ResponseEntity<CategoriaDto> {
        val categoriaCreated = criarCategoriaUseCase.run(categoria.toCategoria())
        return ResponseEntity.ok(categoriaCreated.toCategoriaDto())
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable("id") id: Int): ResponseEntity.BodyBuilder {
        excluirCategoriaUseCase.run(id)
        return ResponseEntity.ok()
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable("id") id: Int, @RequestBody categoria: CategoriaDto): ResponseEntity<CategoriaDto> {
       val categoriaUpdated = atualizarCategoriaUseCase.run(id, categoria = categoria.toCategoria()).toCategoriaDto()
        return ResponseEntity.ok(categoriaUpdated)
    }

}