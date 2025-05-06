package rojojun.simulator

import kotlinx.coroutines.newSingleThreadContext
import rojojun.creator.createSurveyOnConsole
import rojojun.function.getLogger
import rojojun.function.requireNotEmpty
import rojojun.loadPersonFromCSV

class SurveySimulator : Simulator {
    private val log = getLogger<SurveySimulator>()

    override fun run() {
        log.info("[START] >>>> 남성 패션 페르소나 설문 시뮬레이션")

        val personas = loadPersonFromCSV()
        requireNotEmpty(personas)

        val personas2 = requireNotEmpty() {
            log.info("❌ 페르소나 데이터를 불러올 수 없습니다.")
        }(loadPersonFromCSV())

        if (personas.isEmpty()) {
            log.info("❌ 페르소나 데이터를 불러올 수 없습니다. 프로그램을 종료합니다.")
            throw RuntimeException();
        }

        val questions = createSurveyOnConsole()
        if (questions.isEmpty()) {
            log.info("❌ 설문 문항이 없습니다. 프로그램을 종료합니다.")
        }
    }
}