package rojojun.survey.question

data class OpenEndedQuestion(
    override val id: Int,
    override val text: String,
    override val type: String = "open_ended"
) : SurveyQuestion