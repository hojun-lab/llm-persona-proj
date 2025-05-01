import io.ktor.client.statement.*

interface LLMConnector {
    suspend fun connectLLM(apiKey: String)
    fun connected(response: HttpResponse): Boolean
}