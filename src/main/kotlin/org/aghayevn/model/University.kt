package org.aghayevn.model

import kotlin.random.Random

/**
 * created by  Nijat Aghayev on 26.03.20
 */
data class University(val id: Int = Random.nextInt(),
                      var name: String,
                      var address: Address,
                      var ranking: Double,
                      var facultySet: Set<Faculty> = setOf(),
                      var professorSet: Set<Professor> = setOf(),
                      var studentSet: Set<Student> = setOf())