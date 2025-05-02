package rojojun.survey.question

import kotlinx.serialization.Serializable

@Serializable
data class MultipleChoiceQuestion(
    override val id: Int,
    override val text: String,
    val options: List<String>,
    override val type: String = "multiple_choice"
) : SurveyQuestion