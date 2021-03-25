package adapters.exceptions

import java.lang.Exception

class ApplicationException(message: String = "erro de negocio"): Exception(message) {}