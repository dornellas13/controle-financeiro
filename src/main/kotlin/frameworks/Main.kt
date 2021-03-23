package frameworks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("adapters.controllers")
open class Startup

fun main (args: Array<String>) {
    runApplication<Startup>(*args)
}
