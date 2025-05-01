package rojojun.LLM

import LLMConnector
import rojojun.enums.Provider
import rojojun.enums.Provider.*

class LLMFactory {
    companion object {
        fun getProvider(provider: Provider): LLMConnector =
            when (provider) {
                GEMINI -> GeminiConnector()
                OPEN_AI -> TODO()
            }
    }
}