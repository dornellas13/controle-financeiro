package adapters.entities
import adapters.entities.CategoriaEntity
import domains.Categoria
import domains.SubCategoria
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity @Table(name = "subcategoria")
data class SubCategoriaEntity(
    @Id
    @GeneratedValue
    val id: Int = 0,

    val nome: String = "",

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    val categoria: CategoriaEntity? = null
    )

fun SubCategoriaEntity.toSubCategoria() =
    SubCategoria(
        id = this.id,
        nome = this.nome,
        categoria = this.categoria!!.toCategoria()
    )

fun SubCategoria.toSubCategoriaEntity() =
    SubCategoriaEntity(
        id = this.id,
        nome = this.nome,
        categoria = this.categoria.toCategoriaEntity()
    )