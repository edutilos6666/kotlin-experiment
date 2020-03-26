package org.aghayevn.model

import java.time.LocalDateTime
import kotlin.random.Random

data class Subject(
    val id: Int = Random.nextInt(),
    var name: String,
    var facultyId: Int,
    var professorId: Int,
    var studentSet: Set<Student>
)

data class Exam (
    val id: Int = Random.nextInt(),
    val subjectId: Int,
    val date: LocalDateTime
)

data class ExamStudentResultMapping (
    val id: Int = Random.nextInt(),
    val examId: Int,
    val studentId: Int,
    val result: Double
)