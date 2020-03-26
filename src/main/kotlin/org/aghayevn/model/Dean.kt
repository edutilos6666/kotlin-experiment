package org.aghayevn.model

import kotlin.random.Random

/**
 * created by  Nijat Aghayev on 26.03.20
 */
data class Dean(
    override val id: Int = Random.nextInt(),
    override var firstname: String,
    override var lastname: String,
    override var age: Int,
    override var maritalStatus: MaritalStatus,
    override var address: Address,
    override var gender: Gender,
    override var uniId: Int,
    override var facultyId: Int,
    var salary: Double
): Person()