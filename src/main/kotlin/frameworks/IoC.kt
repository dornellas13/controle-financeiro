package frameworks.IoC

import adapters.properties.ApiProperties
import adapters.repositories.*
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@ComponentScan("adapters", "usecases")
@EntityScan("adapters.entities")
@EnableJpaRepositories("adapters.repositories")
@EnableConfigurationProperties(ApiProperties::class)
class IoC {
    @Bean
    fun categoriaRepository(db: ICategoriaJpaRepository) = CategoriaRepository(db)

    @Bean
    fun subCategoriaRepository(db: ISubCategoriaJpaRepository) = SubCategoriaRepository(db)

    @Bean
    fun lancamentoRepository(db: ILancamentoJpaRepository) = LancamentoRepository(db)
}