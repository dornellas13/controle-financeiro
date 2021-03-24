//package adapters.controllers
//
//import adapters.dto.SubCategoriaDto
//import adapters.dto.toSubCategoria
//import adapters.dto.toSubCategoriaDto
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.*
//
//@RestController
//@RequestMapping("/api/lancamentos")
//class LancamentoController(private val obterSubCategoriaUseCase: ObterLancamentoUseCase,
//                             private val atualizarLancamentoUseCase: AtualizarLancamentoUseCase,
//                             private val listarLancamentoUseCase: ListarLancamentoUseCase,
//                             private val excluirLancamentoUseCase: ExcluirLancamentoUseCase
//) {
//
//    @GetMapping("/{id}")
//    fun obter(@PathVariable("id") id: Int): ResponseEntity<LancamentoDto> {
//        return ResponseEntity.ok(obterLancamentoUseCase.run(id).toLancamentoDto())
//    }
//
//    @GetMapping()
//    fun listar(): ResponseEntity<List<LancamentoDto>> {
//        return ResponseEntity.ok(listarLancamentoUseCase.run().map {
//            it.toLancamentoDto()
//        })
//    }
//
//    @DeleteMapping("/{id}")
//    fun excluir(@PathVariable("id") id: Int): ResponseEntity.BodyBuilder {
//        excluirLancamentoUseCase.run(id)
//        return ResponseEntity.ok()
//    }
//
//    @PutMapping("/{id}")
//    fun atualizar(@PathVariable("id") id: Int, @RequestBody lancamento: LancamentoDto): ResponseEntity<LancamentoDto> {
//        val LancamentoUpdated = atualizarLancamentoUseCase.run(id, lancamento = lancamento.toLancamento()).toLancamentoDto()
//        return ResponseEntity.ok(LancamentoUpdated)
//    }
//
//}