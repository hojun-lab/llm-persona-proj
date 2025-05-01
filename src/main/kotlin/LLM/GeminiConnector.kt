package rojojun.LLM

import LLMConnector
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import rojojun.getLogger

val client = HttpClient(CIO)
val requestBody = LLMRequest.connectionTest()
val GEMINI_URL: String = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent"
val logger = getLogger<GeminiConnector>()

class GeminiConnector: LLMConnector {
    override suspend fun connectLLM(apiKey: String) {
        val response: HttpResponse = client.post(GEMINI_URL) {
            parameter("key", apiKey)
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(requestBody))
        }
        connected(response.body())
    }

    override fun connected(response: HttpResponse): Boolean {
        try {
            if (response.status == HttpStatusCode.OK) {
                logger.info("Gemini 연결에 성공하였습니다.")
                return true
            } else {
                logger.error("Gemini 연결에 실패하였습니다.")
                return false
            }
        } catch (e: Exception) {
            logger.error("ErrorMessage: ${e.message}")
            throw e
        }
    }
}

