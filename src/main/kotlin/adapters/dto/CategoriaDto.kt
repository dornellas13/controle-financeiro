package adapters.dto

import domains.Categoria

data class CategoriaDto(
    var id: Int = 0,
    val nome: String
)

fun Categoria.toCategoriaDto() =
    CategoriaDto(
        id = this.id,
        nome = this.nome
    )

fun CategoriaDto.toCategoria() =
    Categoria(
       id = this.id,
       nome = this.nome
    )