package cu.suitetecsa.sdk.network

import org.jsoup.Connection
import org.jsoup.Jsoup

private const val USER_AGENT: String = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:97.0) Gecko/20100101 Firefox/97.0"
private val headers: MutableMap<String, String> = mutableMapOf(
    "Accept" to "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8",
    "Accept-Encoding" to "gzip, deflate, br",
    "Accept-Language" to "es-MX,es;q=0.8,en-US;q=0.5,en;q=0.3"
)

/**
 * Implementación de la factoría de conexiones utilizando Jsoup.
 */
internal object JsoupConnectionFactory : ConnectionFactory {
    /**
     * Crea y devuelve una conexión utilizando la URL y los datos proporcionados.
     *
     * @param url La URL a la que se va a establecer la conexión.
     * @param requestData Datos para la solicitud (opcional).
     * @param cookies Cookies para la solicitud (opcional).
     * @return Objeto `Connection` que representa la conexión creada.
     */
    override fun createConnection(
        url: String,
        requestData: Map<String, String>?,
        cookies: Map<String, String>?
    ): Connection = Jsoup.connect(url).apply {
        userAgent(USER_AGENT)
        headers(headers)
        requestData?.let { data(it) }
        cookies?.let { if (it.isNotEmpty()) cookies(it) }
    }
}
