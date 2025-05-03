package rojojun.persona.factory

import rojojun.persona.Persona

class FashionPersonStrategy: PersonaStrategy {
    override fun parsePersonas(lines: List<String>): List<Persona> {
        if (lines.isEmpty()) return emptyList()

        val headers = lines[0].split(",").map { it.trim() }
        val requiredColumns = listOf(
            "id", "name", "age", "gender", "height", "body_type",
            "preferred_style", "occupation", "shopping_frequency",
            "monthly_fashion_budget", "online_shopping_experience",
            "main_fashion_concerns"
        )

        val missingColumns = requiredColumns.filter { it !in headers }
        if (missingColumns.isNotEmpty()) {
            println("⚠️ 다음 필수 컬럼이 없습니다: $missingColumns")
            return emptyList()
        }

        return lines.drop(1).mapNotNull { line ->
            try {
                val values = line.split(",").map { it.trim() }
                val map = headers.zip(values).toMap()

                Persona(
                    id = map["id"]?.toIntOrNull() ?: return@mapNotNull null,
                    name = map["name"] ?: "",
                    age = map["age"]?.toIntOrNull() ?: 0,
                    gender = map["gender"] ?: "",
                    height = map["height"]?.toIntOrNull() ?: 0,
                    bodyType = map["body_type"] ?: "",
                    preferredStyle = map["preferred_style"] ?: "",
                    occupation = map["occupation"] ?: "",
                    shoppingFrequency = map["shopping_frequency"] ?: "",
                    monthlyFashionBudget = map["monthly_fashion_budget"] ?: "",
                    onlineShoppingExperience = map["online_shopping_experience"] ?: "",
                    mainFashionConcerns = map["main_fashion_concerns"] ?: ""
                )
            } catch (e: Exception) {
                println("⚠️ 파싱 오류: ${e.message}")
                null
            }
        }.also {
            println("✅ 페르소나 ${it.size}명 로드 완료")
        }
    }
}