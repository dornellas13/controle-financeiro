package adapters.dto

import domains.Categoria
import domains.Lancamento


data class LancamentoDto(
    var id: Int = 0,
)

fun Lancamento.toLancamentoDto() =
    LancamentoDto(
        id = this.id,
    )

fun LancamentoDto.toLancamento() =
    Lancamento(
        id = this.id
    )