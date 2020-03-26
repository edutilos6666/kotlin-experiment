package org.aghayevn.model

enum class MaritalStatus {
    SINGLE, SEPARATED, MARRIED
}

enum class Gender {
    MALE, FEMALE
}

abstract class Person {
    abstract val id: Int
    abstract var firstname: String
    abstract var lastname: String
    abstract var age: Int
    abstract var maritalStatus: MaritalStatus
    abstract var address: Address
    abstract var gender: Gender
    abstract var uniId: Int
    abstract var facultyId: Int
}


