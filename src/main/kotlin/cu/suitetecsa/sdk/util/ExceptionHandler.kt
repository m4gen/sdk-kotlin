package cu.suitetecsa.sdk.util

/**
 * Clase que maneja excepciones y crea instancias de excepciones utilizando una factoría de excepciones.
 *
 * @param exceptionFactory La factoría de excepciones utilizada para crear las instancias de excepciones.
 */
class ExceptionHandler private constructor(private val exceptionFactory: ExceptionFactory) {
    /**
     * Maneja una excepción y crea una instancia de excepción utilizando la factoría de excepciones y los
     * mensajes de error dados.
     *
     * @param message El mensaje de la excepción.
     * @param errors Los mensajes de error adicionales (opcional).
     * @return Una instancia de excepción creada.
     */
    fun handleException(message: String, errors: List<String>): Exception {
        val errorMessage = if (errors.isNotEmpty()) {
            errors.joinToString("; ")
        } else {
            "No specific error message"
        }
        return exceptionFactory.createException("$message :: $errorMessage")
    }

    /**
     * Builder para construir una instancia de `ExceptionHandler`.
     *
     * @param exceptionClass La clase de excepción utilizada para crear las instancias de excepciones (opcional).
     */
    class Builder(private val exceptionClass: Class<out Exception> = Exception::class.java) {
        private var excFactory: ExceptionFactory? = null

        /**
         * Establece la factoría de excepciones utilizada para crear las instancias de excepciones.
         *
         * @param exceptionFactory La factoría de excepciones a utilizar.
         * @return El builder actualizado.
         */
        fun setExceptionFactory(exceptionFactory: ExceptionFactory) = apply { excFactory = exceptionFactory }

        /**
         * Construye una instancia de `ExceptionHandler` utilizando la factoría de excepciones especificada.
         * Si no se proporciona una factoría de excepciones, se utiliza una instancia de `ExceptionFactoryImpl`
         * con la clase de excepción dada.
         *
         * @return La instancia de `ExceptionHandler` creada.
         */
        fun build(): ExceptionHandler = ExceptionHandler(excFactory ?: ExceptionFactoryImpl(exceptionClass))
    }
}
