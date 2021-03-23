package domains

data class SubCategoria(
    val id: Int,
    val nome: String,
    var categoria: Categoria
    )