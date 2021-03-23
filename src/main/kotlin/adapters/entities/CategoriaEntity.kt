package adapters.entities
import domains.Categoria
import javax.persistence.*

@Entity
data class CategoriaEntity(
    @Id
    @GeneratedValue
    val id: Int = 0,

    @Column(nullable = false)
    val nome: String = "",

    @OneToMany(mappedBy = "categoria", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
    val subcategorias: List<SubCategoriaEntity> = emptyList()
)

// Mappers
fun CategoriaEntity.toCategoria() =
    Categoria(
        id = this.id,
        nome = this.nome,
        subcategorias = this.subcategorias
    )

fun Categoria.toCategoriaEntity() =
    CategoriaEntity(
        id = this.id,
        nome = this.nome
    )