package adapters.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties("api")
@ConstructorBinding
data class ApiProperties (
    val key: String
)