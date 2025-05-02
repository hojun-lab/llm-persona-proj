package rojojun.survey.answer

data class PersonaSurveyResponse(
    val personaId: Int,
    val personaName: String,
    val responses: Map<String, String>
)
