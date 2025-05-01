package rojojun.persona

import rojojun.enums.Gender

data class Teacher (
    val id: String,
    val name: String,
    val age: Int,
    val gender: Gender,
    val institutionType: InstitutionType,
    val subjectTaught: List<String>,
    val teachingExperienceYears: Int,
    val gradeLevelsTaught: List<String>,
    val usesEduTechTools: Boolean,
    val favoriteEduTechTools: List<String>,
    val attitudeTowardEduTech: AttitudeLevel,
    val mathCurriculumDifficulty: DifficultyLevel,
    val commonStudentChallenges: List<String>,
    val hoursSpentPreparingPerWeek: Int,
    val parentEngagementLevel: EngagementLevel,
    val selfLearningFrequency: LearningFrequency,
    val interestInMathImprovementPrograms: Boolean,
    val feedbackOnCurrentResources: String
)

    enum class InstitutionType {
        SCHOOL, ACADEMY, OTHER
    }

    enum class AttitudeLevel {
        VERY_POSITIVE, POSITIVE, NEUTRAL, NEGATIVE, VERY_NEGATIVE
    }

    enum class DifficultyLevel {
        VERY_EASY, EASY, MODERATE, HARD, VERY_HARD
    }

    enum class EngagementLevel {
        HIGH, MEDIUM, LOW, NONE
    }

    enum class LearningFrequency {
        WEEKLY, MONTHLY, RARELY, NEVER
    }