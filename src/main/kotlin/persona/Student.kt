package rojojun.persona

import rojojun.enums.Gender

data class FashionPersona(
    val id: String,
    val name: String,
    val age: Int,
    val gender: Gender,
    val gradeLevel: String,
    val schoolType: SchoolType,
    val mathInterestLevel: Int,
    val mathAnxietyLevel: Int,
    val currentMathPerformance: PerformanceLevel,
    val preferredLearningStyle: LearningStyle,
    val studyHoursPerWeek: Int,
    val usesEduApps: Boolean,
    val favoriteEduApps: List<String>,
    val parentsSupportLevel: Int,
    val selfMotivationLevel: Int,
    val mainLearningChallenges: List<String>,
    val usesPrivateTutoring: Boolean,
    val feedbackOnCurrentMethods: String
) : AbstractPersona()

enum class SchoolType {
    PUBLIC, PRIVATE, INTERNATIONAL
}

enum class PerformanceLevel {
    HIGH, MEDIUM, LOW
}

enum class LearningStyle {
    VIDEO, READING, INTERACTIVE
}