package rojojun.survey.analysis

sealed interface QuestionAnalysis {
    val questionText: String
    val type: String
}