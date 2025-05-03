package rojojun.persona.factory

object PersonaStrategyFactory {
    fun getStrategy(type: PersonaType): PersonaStrategy {
        return when (type) {
            PersonaType.FASHION -> FashionPersonStrategy()
            // 확장 가능: "tech" -> TechPersonStrategy()
            else -> throw IllegalArgumentException("❌ 알 수 없는 전략 타입: $type")
        }
    }
}

enum class PersonaType{
    FASHION
}