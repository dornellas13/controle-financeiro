package adapters.dto

import domains.Categoria
import domains.SubCategoria

data class SubCategoriaDto(
    var id: Int = 0,
    val nome: String
)

fun SubCategoria.toSubCategoriaDto() =
    SubCategoriaDto(
        id = this.id,
        nome = this.nome
    )

fun SubCategoriaDto.toSubCategoria(categoria: Categoria) =
        SubCategoria(
        id = this.id,
        nome = this.nome,
        categoria = categoria
    )