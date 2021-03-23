package domains

import adapters.entities.SubCategoriaEntity

data class Categoria(
    val id: Int,
    val nome: String,
    val subcategorias: List<SubCategoriaEntity>
)