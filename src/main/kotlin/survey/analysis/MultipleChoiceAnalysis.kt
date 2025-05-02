package rojojun.survey.analysis

data class MultipleChoiceAnalysis(
    override val questionText: String,
    val counts: Map<String, Int>,
    val percentages: Map<String, Double>,
    override val type: String = "multiple_choice"
) : QuestionAnalysis
