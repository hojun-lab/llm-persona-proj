package rojojun.survey.question

import kotlinx.serialization.Serializable

@Serializable
sealed interface SurveyQuestion {
    val id: Int
    val text: String
    val type: String
}