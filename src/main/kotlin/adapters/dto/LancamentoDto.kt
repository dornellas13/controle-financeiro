package adapters.dto

import domains.Lancamento
import domains.SubCategoria
import java.util.*


data class LancamentoDto(
    var id: Int = 0,
    val valor: Double,
    val data: Date = Date(),
    val comentario: String
)

fun Lancamento.toLancamentoDto() =
    LancamentoDto(
        id = this.id,
        valor = this.valor,
        data = this.data,
        comentario = this.comentario
    )

fun LancamentoDto.toLancamento(subcategoria: SubCategoriaDto) =
    Lancamento(
        id = this.id,
        valor = this.valor,
        data = this.data,
        comentario = this.comentario,
        subcategoria =  subcategoria.toSubCategoria()
    )

fun LancamentoDto.toLancamento() =
    Lancamento(
        id = this.id,
        valor = this.valor,
        data = this.data,
        comentario = this.comentario,
        subcategoria =  SubCategoria()
    )