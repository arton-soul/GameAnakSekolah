package com.example.eduquest

import com.example.eduquest.data.local.entity.QuestionEntity
import com.example.eduquest.data.local.seed.ExamQuestionStarterData_SD
import com.example.eduquest.data.local.seed.ExamQuestionStarterData_SMA
import com.example.eduquest.data.local.seed.ExamQuestionStarterData_SMP
import com.example.eduquest.data.local.seed.QuestionStarterData
import com.example.eduquest.data.local.seed.QuestionStarterData_SMA
import com.example.eduquest.data.local.seed.QuestionStarterData_SMP
import org.junit.Test
import java.io.File

class ExportBankSoalTest {

    private fun escape(text: String): String {
        return text
            .replace("\\", "\\\\")
            .replace("\"", "\\\"")
            .replace("\b", "\\b")
            .replace("\u000C", "\\f")
            .replace("\n", "\\n")
            .replace("\r", "\\r")
            .replace("\t", "\\t")
    }

    private fun toJson(q: QuestionEntity): String {
        return """
        {
          "id": "${escape(q.id)}",
          "grade": ${q.grade},
          "subjectId": "${escape(q.subjectId)}",
          "topicId": "${escape(q.topicId)}",
          "difficulty": "${escape(q.difficulty)}",
          "type": "${escape(q.type)}",
          "question": "${escape(q.question)}",
          "optionA": "${escape(q.optionA)}",
          "optionB": "${escape(q.optionB)}",
          "optionC": "${escape(q.optionC)}",
          "optionD": "${escape(q.optionD)}",
          "answer": "${escape(q.answer)}",
          "explanation": "${escape(q.explanation)}",
          "xp": ${q.xp},
          "educationLevel": "${escape(q.educationLevel)}",
          "isExam": ${q.isExam}
        }
        """.trimIndent()
    }

    private fun listToJson(list: List<QuestionEntity>): String {
        val items = list.joinToString(",\n") { toJson(it) }
        return "[\n$items\n]"
    }

    @Test
    fun exportAllQuestionsToBankSoalFolder() {
        val outputDir = File("D:/Android/GameAnakSekolah/bank_soal")
        if (!outputDir.exists()) {
            outputDir.mkdirs()
        }

        // 1. Export SD Questions
        val sdList = QuestionStarterData.STARTER_QUESTIONS_SD + ExamQuestionStarterData_SD.SD_EXAM_QUESTIONS
        File(outputDir, "questions_sd.json").writeText(listToJson(sdList), Charsets.UTF_8)

        // 2. Export SMP Questions
        val smpList = QuestionStarterData_SMP.SMP_QUESTIONS + ExamQuestionStarterData_SMP.SMP_EXAM_QUESTIONS
        File(outputDir, "questions_smp.json").writeText(listToJson(smpList), Charsets.UTF_8)

        // 3. Export SMA Questions
        val smaList = QuestionStarterData_SMA.SMA_QUESTIONS + ExamQuestionStarterData_SMA.SMA_EXAM_QUESTIONS
        File(outputDir, "questions_sma.json").writeText(listToJson(smaList), Charsets.UTF_8)

        // 4. Export All Exam Questions
        val examList = ExamQuestionStarterData_SD.SD_EXAM_QUESTIONS +
                ExamQuestionStarterData_SMP.SMP_EXAM_QUESTIONS +
                ExamQuestionStarterData_SMA.SMA_EXAM_QUESTIONS
        File(outputDir, "questions_exam.json").writeText(listToJson(examList), Charsets.UTF_8)

        // 5. Export Manifest
        val manifestJson = """
        {
          "content_version": 1,
          "app_min_version": 1,
          "last_updated": "2026-10-11",
          "description": "Bank Soal Resmi EduQuest SD, SMP, SMA & Ruang Ujian Sekolah",
          "total_questions": ${sdList.size + smpList.size + smaList.size},
          "endpoints": {
            "sd": "bank_soal/questions_sd.json",
            "smp": "bank_soal/questions_smp.json",
            "sma": "bank_soal/questions_sma.json",
            "exam": "bank_soal/questions_exam.json"
          }
        }
        """.trimIndent()
        File(outputDir, "manifest.json").writeText(manifestJson, Charsets.UTF_8)

        println("Bank Soal successfully exported to $outputDir!")
    }
}
