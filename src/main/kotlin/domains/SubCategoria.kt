package domains

data class SubCategoria(
    val id: Int = 0,
    val nome: String = "",
    var categoria: Categoria
    )