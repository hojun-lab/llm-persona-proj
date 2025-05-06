package rojojun

import rojojun.function.loadFromResourceOrThrow
import rojojun.persona.AbstractPersona
import rojojun.persona.factory.PersonaStrategyFactory
import rojojun.persona.factory.PersonaType
import java.io.InputStreamReader

fun loadPersonFromCSV(
    filePath: String = "persona_data.csv",
    log: (String) -> Unit = { println(it) }
): List<AbstractPersona> {

    log("📊 페르소나 데이터를 로드합니다...")

    val file =  InputStreamReader(loadFromResourceOrThrow(filePath))
    val lines = file.readLines()
    if (lines.isEmpty()) {
        log("❌ 빈 파일입니다: $filePath")
        return emptyList()
    }

    val strategy = PersonaStrategyFactory.getStrategy(PersonaType.FASHION)


    return strategy.parsePersonas(lines)
}