package rojojun.survey.answer

data class PersonaSurveyResponse(
    val personaId: Int,
    val personaName: String,
    val responses: MutableMap<String, String> = mutableMapOf()
)
