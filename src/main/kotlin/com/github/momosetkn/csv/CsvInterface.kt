package com.github.momosetkn.com.github.momosetkn.csv

import java.io.InputStream
import java.io.OutputStream
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.OffsetDateTime
import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties


interface ICsv {
    fun readEach(inputStream: InputStream, block: (ITypedCsvData) -> Unit)
    fun <E: ITypedCsvData> writeEach(outputStream: OutputStream, inputIterator: Iterator<E>)
}

interface ITypedCsvData {
    val propertyInt0: Int
    val propertyInt1: Int
    val propertyLong0: Long
    val propertyLong1: Long
    val propertyFloat0: Float
    val propertyFloat1: Float
    val propertyDouble0: Double
    val propertyDouble1: Double
    val propertyString0_0: String
    val propertyString0_1: String
    val propertyString0_2: String
    val propertyString0_3: String
    val propertyString1_0: String
    val propertyString1_1: String
    val propertyString1_2: String
    val propertyString1_3: String
    val propertyString2_0: String
    val propertyString2_1: String
    val propertyString2_2: String
    val propertyString2_3: String
    val propertyString3_0: String
    val propertyString3_1: String
    val propertyString3_2: String
    val propertyString3_3: String
    val propertyString4_0: String
    val propertyString4_1: String
    val propertyString4_2: String
    val propertyString4_3: String
    val propertyString5_0: String
    val propertyString5_1: String
    val propertyString5_2: String
    val propertyString5_3: String
    val propertyString6_0: String
    val propertyString6_1: String
    val propertyString6_2: String
    val propertyString6_3: String
    val propertyString7_0: String
    val propertyString7_1: String
    val propertyString7_2: String
    val propertyString7_3: String
    val localDate0: LocalDate
    val localDate1: LocalDate
    val localDateTime0: LocalDateTime
    val localDateTime1: LocalDateTime
    val offsetDateTime0: OffsetDateTime
    val offsetDateTime1: OffsetDateTime


    fun <E: ITypedCsvData> copyToOther(clazz: KClass<E>): E {
        val constructor = clazz.constructors.first()
        // コピー先クラスの順番へ合わせる
        val args = constructor.parameters.map { parameter ->
            valueMaps[parameter.name]!!.get(this)
        }.toTypedArray()
        return constructor.call(*args)
    }
}

private val valueMaps = ITypedCsvData::class.memberProperties.associateBy {
    it.name
}
