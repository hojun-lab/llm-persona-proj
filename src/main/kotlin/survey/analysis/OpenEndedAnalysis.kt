package rojojun.survey.analysis

data class OpenEndedAnalysis(
    override val questionText: String,
    val sampleResponses: List<String>,
    override val type: String = "open_ended"
) : QuestionAnalysis
