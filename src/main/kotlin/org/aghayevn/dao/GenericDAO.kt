package org.aghayevn.dao

/**
 * created by  Nijat Aghayev on 26.03.20
 */
interface GenericDAO<T, D> {
    fun insert(one: T): Unit
    fun insertAll(vararg list: T)
    fun update(one: T): T?
    fun delete(one: T): T?
    fun deleteById(id: D): T?
    fun findById(id: D): T?
    fun findAll(): MutableList<T>
    fun truncate(): Unit
}