package com.example.eduquest.domain.model

enum class Difficulty {
    EASY,
    NORMAL,
    HARD
}

enum class QuestionType {
    MULTIPLE_CHOICE,
    TRUE_FALSE
}

data class QuestionOption(
    val key: String,
    val text: String
)

data class Question(
    val id: String,
    val grade: Int,
    val subjectId: String,
    val topicId: String,
    val difficulty: Difficulty = Difficulty.EASY,
    val type: QuestionType = QuestionType.MULTIPLE_CHOICE,
    val questionText: String,
    val optionA: String,
    val optionB: String,
    val optionC: String = "",
    val optionD: String = "",
    val correctAnswer: String,
    val explanation: String,
    val xpReward: Int = 100,
    val educationLevel: String = "SD",
    val isExam: Boolean = false
) {
    fun getOptions(): List<QuestionOption> {
        val list = mutableListOf(
            QuestionOption("A", optionA),
            QuestionOption("B", optionB)
        )
        if (optionC.isNotBlank()) list.add(QuestionOption("C", optionC))
        if (optionD.isNotBlank()) list.add(QuestionOption("D", optionD))
        return list
    }

    /**
     * Returns a new Question where options (A, B, C, D) are randomly shuffled,
     * and correctAnswer is automatically updated to the new key corresponding to the original correct answer.
     */
    fun withShuffledOptions(): Question {
        val currentOptions = mutableListOf<Pair<String, String>>()
        if (optionA.isNotBlank()) currentOptions.add("A" to optionA)
        if (optionB.isNotBlank()) currentOptions.add("B" to optionB)
        if (optionC.isNotBlank()) currentOptions.add("C" to optionC)
        if (optionD.isNotBlank()) currentOptions.add("D" to optionD)

        if (currentOptions.size <= 1) return this

        // Preserve standard Benar / Salah layout for TRUE_FALSE questions
        if (type == QuestionType.TRUE_FALSE) return this

        val correctText = currentOptions.firstOrNull { it.first.equals(correctAnswer, ignoreCase = true) }?.second
            ?: return this

        val shuffledTexts = currentOptions.map { it.second }.shuffled()
        val keys = listOf("A", "B", "C", "D")
        val newCorrectIndex = shuffledTexts.indexOf(correctText)
        val newCorrectAnswer = if (newCorrectIndex in keys.indices) keys[newCorrectIndex] else correctAnswer

        return this.copy(
            optionA = shuffledTexts.getOrElse(0) { "" },
            optionB = shuffledTexts.getOrElse(1) { "" },
            optionC = shuffledTexts.getOrElse(2) { "" },
            optionD = shuffledTexts.getOrElse(3) { "" },
            correctAnswer = newCorrectAnswer
        )
    }
}