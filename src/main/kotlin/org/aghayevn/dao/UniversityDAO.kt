package org.aghayevn.dao

import org.aghayevn.model.Professor
import org.aghayevn.model.University

/**
 * created by  Nijat Aghayev on 26.03.20
 */
interface UniversityDAO: GenericDAO<University, Int> {
    fun findBy(name: String?,
               country: String?,
               city: String?,
               zip: String?,
               street: String?,
               minRanking: Double?,
               maxRanking: Double?): List<University>
}