package rojojun.survey.creator

import rojojun.survey.question.MultipleChoiceQuestion
import rojojun.survey.question.OpenEndedQuestion
import rojojun.survey.question.SurveyQuestion

class SurveyCreator {
    fun createSurveyOnConsole(): List<SurveyQuestion> {
        println("\n📝 설문지 작성을 시작합니다.")
        println("객관식 및 주관식 문항을 포함하여 최소 10개 이상 작성해주세요.")

        val questions = mutableListOf<SurveyQuestion>()
        var currentId = 1

        while (true) {
            println("\nQ$currentId")
            println("문항 유형을 선택하세요:")
            println("1: 객관식")
            println("2: 주관식")
            println("0: 설문 작성 완료 (최소 10개 필요)")

            print("선택: ")
            val choice = readLine()?.trim()?.toIntOrNull() ?: 1

            if (choice == 0) {
                if (questions.size < 10) {
                    println("❌ 최소 10개 문항이 필요합니다. 현재 ${questions.size}개 작성됨.")
                    continue
                }
                break
            }

            print("질문 내용을 입력하세요: ")
            val questionText = readLine()?.trim() ?: ""

            if (questionText.isEmpty()) {
                println("❌ 질문 내용을 입력해주세요.")
                continue
            }

            when (choice) {
                1 -> { // 객관식
                    val options = mutableListOf<String>()
                    println("선택지를 입력하세요 (빈 값 입력 시 완료):")

                    var optionNum = 1
                    while (true) {
                        print("선택지 $optionNum: ")
                        val option = readLine()?.trim() ?: ""
                        if (option.isEmpty()) {
                            if (options.size < 2) {
                                println("❌ 객관식 문항은 최소 2개 이상의 선택지가 필요합니다.")
                                continue
                            }
                            break
                        }
                        options.add(option)
                        optionNum++
                    }

                    questions.add(MultipleChoiceQuestion(currentId, questionText, options))
                }
                2 -> { // 주관식
                    questions.add(OpenEndedQuestion(currentId, questionText))
                }
                else -> {
                    println("❌ 잘못된 선택입니다. 다시 선택해주세요.")
                    continue
                }
            }

            println("✅ 문항이 추가되었습니다.")
            currentId++
        }

        println("✅ 설문지 작성 완료 (총 ${questions.size}개 문항)")
        return questions
    }
}