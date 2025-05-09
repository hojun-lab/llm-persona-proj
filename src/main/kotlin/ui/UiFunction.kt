package rojojun.ui

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import rojojun.persona.AbstractPersona
import rojojun.survey.answer.PersonaSurveyResponse
import rojojun.survey.question.SurveyQuestion

fun selectSampleSize(personas: List<AbstractPersona>, questions: List<SurveyQuestion>): Int {
    val maxSize = personas.size
    println("\n👥 설문 진행할 페르소나 수 선택")
    println("최대 ${maxSize}명까지 선택 가능합니다.")

    var sampleSize = 20.coerceAtMost(maxSize)

    while (true) {
        println("인원 수 (기본: $sampleSize, 최대: $maxSize): ")
        val input = readLine()?.trim()

        if (input.isNullOrEmpty()) {
            break
        }

        val newSize = input.toIntOrNull()
        if (newSize != null && newSize in 1..maxSize) {
            sampleSize = newSize
            break
        } else {
            println("❌ 1에서 $maxSize 사이의 숫자를 입력해주세요.")
        }
    }

    println("🔍 ${sampleSize}명의 페르소나에게 설문을 진행합니다...")
    return sampleSize
}

fun generateResponses(personas: List<AbstractPersona>, questions: List<SurveyQuestion>, sampleSize: Int): List<PersonaSurveyResponse> {
    val actualSampleSize = minOf(sampleSize, personas.size)
    println("\n🤖 ${actualSampleSize}명의 페르소나에 대한 응답을 생성합니다...")

    // Randomly sample personas
    val sampledPersonas = personas.shuffled().take(actualSampleSize)
    val responses = mutableListOf<PersonaSurveyResponse>()

    // Show progress
    var progress = 0

    runBlocking {
        val jobs = sampledPersonas.map { persona ->
            launch {
                val surveyResponse = PersonaSurveyResponse(persona.id, persona.name)

                // Select random personality traits for this persona
                val traits = personalityTraits.shuffled().take(2)
                val speechStyle = speechStyles.random()
                val feedbackStyle = feedbackStyles.random()

                questions.forEach { question ->
                    val qId = "Q${question.id}"

                    val answer = when (question) {
                        is MultipleChoiceQuestion -> {
                            // Simulate choosing an option based on persona characteristics
                            generateMultipleChoiceResponse(persona, question, traits)
                        }
                        is OpenEndedQuestion -> {
                            // Generate a open-ended response based on persona
                            generateOpenEndedResponse(persona, question, traits, speechStyle, feedbackStyle)
                        }
                    }

                    surveyResponse.responses[qId] = answer
                }

                synchronized(responses) {
                    responses.add(surveyResponse)
                    progress++
                    val percent = (progress * 100) / actualSampleSize
                    println("진행률: $progress/$actualSampleSize ($percent%)")
                }
            }
        }

        jobs.forEach { it.join() }
    }

    println("✅ ${actualSampleSize}명의 페르소나에 대한 응답 생성 완료!")
    return responses
}