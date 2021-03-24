package frameworks.IoC

import adapters.repositories.*
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@ComponentScan("adapters.controllers", "usecases")
@EntityScan("adapters.entities")
@EnableJpaRepositories("adapters.repositories")
class IoC {
    @Bean
    fun categoriaRepository(db: ICategoriaJpaRepository) = CategoriaRepository(db)

    @Bean
    fun subCategoriaRepository(db: ISubCategoriaJpaRepository) = SubCategoriaRepository(db)

    @Bean
    fun lancamentoRepository(db: ILancamentoJpaRepository) = LancamentoRepository(db)
}