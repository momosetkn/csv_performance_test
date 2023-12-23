package com.github.momosetkn.csv.data

import com.github.momosetkn.com.github.momosetkn.csv.ITypedCsvData
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.OffsetTime
import java.time.ZoneOffset
import kotlin.random.Random

object GenerateData {
    val localDate = LocalDate.of(2020, 1, 1)
    val localTime = LocalTime.of(15, 1, 1)
    val localDateTime = LocalDateTime.of(localDate, localTime)
    var stringDataCount = 0

    inline fun <reified T> testValue(): T {
        return when (T::class) {
            Int::class -> Random.nextInt()
            Long::class -> Random.nextLong()
            Float::class -> Random.nextFloat()
            Double::class -> Random.nextDouble()
            String::class -> testStringValue(stringDataCount++ % 4)
            LocalDate::class -> localDate.plusDays(Random.nextLong() % 1000)
            LocalTime::class -> localTime.plusSeconds(Random.nextLong() % 1000)
            LocalDateTime::class -> localDateTime.plusDays(Random.nextLong() % 1000)
            OffsetTime::class -> localTime.plusSeconds(Random.nextLong() % 1000).atOffset(ZoneOffset.UTC)
            OffsetDateTime::class -> localDateTime.plusDays(Random.nextLong() % 1000).atOffset(ZoneOffset.UTC)
            else -> throw NotImplementedError("not supported ${T::class} type")
        } as T
    }

    fun testStringValue(cnt: Int): String {
        val length = stringLength(cnt)
        val stringBuilder = StringBuilder(length)
        repeat(length) {
            stringBuilder.append(testChar())
        }

        return stringBuilder.toString()
    }

    private fun stringLength(length: Int): Int {
        var result = 0
        repeat(length) {
            if (result == 0) {
                result = 1
            } else {
                result *= 10
            }
        }
        return result
    }

    fun testChar(): Char {
        val alphabet = ('a'..'z') + ('A'..'Z')
        return alphabet.random()
    }

    fun testTypedCsvData(): TypedCsvData {
        return TypedCsvData(
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
            testValue(),
        )
    }
}


data class TypedCsvData(
    override val propertyInt0: Int,
    override val propertyInt1: Int,
    override val propertyLong0: Long,
    override val propertyLong1: Long,
    override val propertyFloat0: Float,
    override val propertyFloat1: Float,
    override val propertyDouble0: Double,
    override val propertyDouble1: Double,
    override val propertyString0_0: String,
    override val propertyString0_1: String,
    override val propertyString0_2: String,
    override val propertyString0_3: String,
    override val propertyString1_0: String,
    override val propertyString1_1: String,
    override val propertyString1_2: String,
    override val propertyString1_3: String,
    override val propertyString2_0: String,
    override val propertyString2_1: String,
    override val propertyString2_2: String,
    override val propertyString2_3: String,
    override val propertyString3_0: String,
    override val propertyString3_1: String,
    override val propertyString3_2: String,
    override val propertyString3_3: String,
    override val propertyString4_0: String,
    override val propertyString4_1: String,
    override val propertyString4_2: String,
    override val propertyString4_3: String,
    override val propertyString5_0: String,
    override val propertyString5_1: String,
    override val propertyString5_2: String,
    override val propertyString5_3: String,
    override val propertyString6_0: String,
    override val propertyString6_1: String,
    override val propertyString6_2: String,
    override val propertyString6_3: String,
    override val propertyString7_0: String,
    override val propertyString7_1: String,
    override val propertyString7_2: String,
    override val propertyString7_3: String,
    override val localDate0: LocalDate,
    override val localDate1: LocalDate,
    override val localDateTime0: LocalDateTime,
    override val localDateTime1: LocalDateTime,
    override val offsetDateTime0: OffsetDateTime,
    override val offsetDateTime1: OffsetDateTime,
) : ITypedCsvData
