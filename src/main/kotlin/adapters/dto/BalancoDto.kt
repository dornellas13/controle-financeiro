package adapters.dto

import domains.Balanco


data class BalancoDto(
    val categoria: CategoriaDto? = null,
    val saldo: Double,
    val receita: Double,
    val despesa: Double
)

fun Balanco.toBalancoDto() =
    BalancoDto(
        categoria = if(this.categoria != null) this.categoria.toCategoriaDto() else null,
        saldo = this.saldo,
        receita = this.receita,
        despesa = this.despesa
    )