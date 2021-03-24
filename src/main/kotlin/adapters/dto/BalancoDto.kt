package adapters.dto

import domains.Balanco


data class BalancoDto(
    val categoria: CategoriaDto,
    val saldo: Double,
    val receita: Double,
    val despesa: Double
)

fun Balanco.toBalancoDto() =
    BalancoDto(
        categoria = this.categoria!!.toCategoriaDto(),
        saldo = this.saldo!!,
        receita = this.receita,
        despesa = this.despesa!!
    )