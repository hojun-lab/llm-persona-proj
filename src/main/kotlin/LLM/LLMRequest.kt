package rojojun.LLM

import kotlinx.serialization.Serializable

@Serializable
data class LLMRequest(val contents: List<ContentPart>) {

    companion object {
        fun connectionTest(): LLMRequest =
            LLMRequest(
                contents = listOf(
                    ContentPart(
                        role = "user",
                        parts = listOf(TextPart("연결 테스트 입니다."))
                    )
                )
            )
    }
}

@Serializable
data class ContentPart(val role: String, val parts: List<TextPart>)

@Serializable
data class TextPart(val text: String)