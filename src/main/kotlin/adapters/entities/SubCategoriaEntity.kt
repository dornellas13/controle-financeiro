package adapters.entities
import adapters.entities.CategoriaEntity
import javax.persistence.*;

@Entity
data class SubCategoriaEntity(
    @Id
    @GeneratedValue
    val id: Long = 0,

    val nome: String = "",

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    val categoria: CategoriaEntity? = null
    )