package adapters.controllers
import adapters.entities.CategoriaEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import usecases.categorias.CriarCategoriaUseCase
import usecases.repositories.ICategoriaRepository
import java.util.*

@RestController
@RequestMapping("/api/categorias")
class CategoriaController(private val categoriaRepository: ICategoriaRepository, private val criarCategoriaUseCase: CriarCategoriaUseCase) {
//    @GetMapping("/{id}")
//    fun obter(@PathVariable("id") id: Int): ResponseEntity<CategoriaEntity>? {
//        return categoriaRepository.findById(id).map {
//            ResponseEntity.ok(it)
//        }.orElseGet({ResponseEntity.notFound().build()})
//    }
//    @GetMapping()
//    fun listar(): List<ResponseEntity<CategoriaEntity>> {
//        return categoriaRepository.findAll().map {
//            ResponseEntity.ok(it)
//        }
//    }

    @PostMapping()
    fun criar(@RequestBody categoria: CategoriaEntity): ResponseEntity<CategoriaEntity> {
        val categoria = criarCategoriaUseCase.run(categoria)
        return ResponseEntity.ok(categoria)
    }

//    @DeleteMapping("/{id}")
//    fun excluir(@PathVariable("id") id: Int): ResponseEntity.BodyBuilder {
//        categoriaRepository.deleteById(id)
//        return ResponseEntity.ok()
//    }
//
//    @PutMapping("/{id}")
//    fun atualizar(@PathVariable("id") id: Int, @RequestBody categoria: CategoriaEntity): ResponseEntity<CategoriaEntity> {
//        val categoria = categoriaRepository.getById(id)
//        val categoriaUpdated = categoriaRepository.save(categoria.copy(nome = categoria.nome))
//        return if (categoriaUpdated != null) {
//            ResponseEntity.ok(categoriaUpdated)
//        } else {
//            ResponseEntity.notFound().build()
//        }
//    }
}