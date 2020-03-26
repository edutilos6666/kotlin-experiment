package org.aghayevn.model

import kotlin.random.Random

/**
 * created by  Nijat Aghayev on 26.03.20
 */
data class Address(val id: Int = Random.nextInt(),
                   var country: String,
                   var city: String,
                   var zip: String,
                   var street: String)