package org.aghayevn.dao

import org.aghayevn.model.University
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * created by  Nijat Aghayev on 26.03.20
 */
class UniversityDAOInMemoryImpl: UniversityDAO {
    private var container: MutableMap<Int, University> = mutableMapOf()
    private val logger: Logger  = LoggerFactory.getLogger(UniversityDAOInMemoryImpl::class.java)


    override fun insertAll(vararg list: University) {
        list.forEach {
            insert(it)
        }
    }

    override fun truncate() {
        container = mutableMapOf()
    }

    override fun findBy(
        name: String?,
        country: String?,
        city: String?,
        zip: String?,
        street: String?,
        minRanking: Double?,
        maxRanking: Double?
    ): List<University> {
        var ret: MutableList<University> = container.values.toMutableList()
        if(name != null) ret = ret.filter { it.name == name }.toMutableList()
        if(country != null) ret = ret.filter { it.address.country == country }.toMutableList()
        if(city != null) ret = ret.filter { it.address.city == city }.toMutableList()
        if(zip != null) ret = ret.filter { it.address.zip == zip }.toMutableList()
        if(street != null) ret = ret.filter { it.address.street == street }.toMutableList()
        if(minRanking != null) ret = ret.filter { it.ranking >= minRanking }.toMutableList()
        if(maxRanking != null) ret = ret.filter { it.ranking <= maxRanking }.toMutableList()
        return ret
    }

    override fun insert(one: University) {
        if(container[one.id] != null) {
            logger.warn("University with id = ${one.id} already exists.")
            return
        }
        container[one.id] = one
    }

    override fun update(one: University): University? {
        val ret: University? = container[one.id]
        if(ret == null) {
            logger.warn("University with id = ${one.id} does not exist in container.")
            return null
        }
        container[one.id] = one
        return one
    }

    override fun delete(one: University): University? {
        val ret: University? = container[one.id]
        if(ret == null) {
            logger.warn("University with id = ${one.id} does not exist in container.")
            return null
        }
        container.remove(one.id)
        return ret
    }

    override fun deleteById(id: Int): University? {
        val ret: University? = container[id]
        if(ret == null) {
            logger.warn("University with id = ${id} does not exist in container.")
            return null
        }
        container.remove(id)
        return ret
    }

    override fun findById(id: Int): University? {
        return container[id]
    }

    override fun findAll(): MutableList<University> {
        return container.values.toMutableList()
    }
}