package adapters.controllers
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categorias")
class CategoriaController {
    @GetMapping("/{id}")
    fun obter(@PathVariable("id") id: Int): Int {
        return id
    }
    @GetMapping()
    fun listar() {

    }

    @PostMapping()
    fun criar() {

    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable("id") id: Int) {

    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable("id") id: Int) {

    }
}