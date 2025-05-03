package rojojun

import rojojun.LLM.LLMFactory
import rojojun.config.loadEnvConfig
import rojojun.enums.Provider

suspend fun main() {
    val connector = LLMFactory.getProvider(Provider.GEMINI)
    val config = loadEnvConfig()

    print("🔑 Google API 키를 로드하고 있습니다.: ")
    val apiKey = config!!.gemini_key
    if (apiKey.isEmpty()) {
        println("⚠️ API 키가 필요합니다")
    } else {
        connector.connectLLM(apiKey)
    }
}