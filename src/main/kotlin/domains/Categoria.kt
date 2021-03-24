package domains

import adapters.entities.SubCategoriaEntity

data class Categoria(
    val id: Int = 0,
    val nome: String = "",
    val subcategorias: List<SubCategoriaEntity> = emptyList()
)