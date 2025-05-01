package rojojun

import rojojun.LLM.LLMFactory
import rojojun.enums.Provider

suspend fun main() {
    val connector = LLMFactory.getProvider(Provider.GEMINI)

    print("🔑 Google API 키를 입력하세요: ")
    val apiKey = readln().trim()
    if (apiKey.isEmpty()) {
        println("⚠️ API 키가 필요합니다")
    } else {
        connector.connectLLM(apiKey)
    }
}