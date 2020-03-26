package org.aghayevn.model

import kotlin.random.Random

data class Faculty(
    val id: Int = Random.nextInt(),
    var name: String,
    var universityId: Int,
    var deanId: Int,
    var subjectSet: Set<Subject>,
    var studentSet: Set<Student>,
    var professorSet: Set<Professor>
)
