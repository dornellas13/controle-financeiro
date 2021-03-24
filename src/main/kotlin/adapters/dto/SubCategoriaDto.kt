package adapters.dto

import domains.Categoria
import domains.SubCategoria

data class SubCategoriaDto(
    var id: Int = 0,
    val nome: String,
    var categoria: CategoriaDto? = null
)

fun SubCategoria.toSubCategoriaDto() =
    SubCategoriaDto(
        id = this.id,
        nome = this.nome,
        categoria = this.categoria!!.toCategoriaDto()
    )

fun SubCategoriaDto.toSubCategoria(categoria: Categoria) =
        SubCategoria(
        id = this.id,
        nome = this.nome,
        categoria = categoria
    )

fun SubCategoriaDto.toSubCategoria() =
    SubCategoria(
        id = this.id,
        nome = this.nome,
        categoria = Categoria()
    )