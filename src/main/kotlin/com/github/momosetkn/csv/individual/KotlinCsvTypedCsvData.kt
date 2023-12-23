package com.github.momosetkn.csv.individual

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import com.github.doyaaaaaken.kotlincsv.dsl.csvWriter
import com.github.momosetkn.com.github.momosetkn.csv.ICsv
import com.github.momosetkn.com.github.momosetkn.csv.ITypedCsvData
import io.blackmo18.kotlin.grass.dsl.grass
import kotlinx.coroutines.runBlocking
import java.io.InputStream
import java.io.OutputStream
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.OffsetDateTime

class KotlinCsvExample : ICsv {
    @OptIn(ExperimentalStdlibApi::class)
    override fun readEach(inputStream: InputStream, block: (ITypedCsvData) -> Unit) {
        val csvContents = csvReader()
            .readAllWithHeader(inputStream)

        val dataClasses = grassParser.harvest(csvContents)
        dataClasses.forEach {
            block(it)
        }
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun <E : ITypedCsvData> writeEach(outputStream: OutputStream, inputIterator: Iterator<E>) {
        runBlocking {
            csvWriter().openAsync(outputStream) {
                val header = grassParser.ctx.customKeyMapDataProperty?.map {
                    it.key
                }
                writeRow(*header!!.toTypedArray())

                val valueGetters = grassParser.ctx.customKeyMapDataProperty!!.map {
                    it.value.getter
                }

                inputIterator.forEach { row ->
                    val valueList = valueGetters.map {
                        it.call(row.copyToOther(KotlinCsvTypedCsvData::class))
                    }
                    writeRow(valueList)
                }
            }
        }
    }
}

data class KotlinCsvTypedCsvData(
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


@OptIn(ExperimentalStdlibApi::class)
val grassParser = grass<KotlinCsvTypedCsvData> {
    dateFormat = "yyyy-MM-dd"
    timeFormat = "HH:mm:ss"
    dateTimeSeparator = "T"
    // where is Java8DateTime?
//    customDataTypes = arrayListOf(Java8DateTime)v2

    customKeyMapDataProperty = mapOf(
        "propertyInt0" to KotlinCsvTypedCsvData::propertyInt0,
        "propertyInt1" to KotlinCsvTypedCsvData::propertyInt1,
        "propertyLong0" to KotlinCsvTypedCsvData::propertyLong0,
        "propertyLong1" to KotlinCsvTypedCsvData::propertyLong1,
        "propertyFloat0" to KotlinCsvTypedCsvData::propertyFloat0,
        "propertyFloat1" to KotlinCsvTypedCsvData::propertyFloat1,
        "propertyDouble0" to KotlinCsvTypedCsvData::propertyDouble0,
        "propertyDouble1" to KotlinCsvTypedCsvData::propertyDouble1,
        "propertyString0_0" to KotlinCsvTypedCsvData::propertyString0_0,
        "propertyString0_1" to KotlinCsvTypedCsvData::propertyString0_1,
        "propertyString0_2" to KotlinCsvTypedCsvData::propertyString0_2,
        "propertyString0_3" to KotlinCsvTypedCsvData::propertyString0_3,
        "propertyString1_0" to KotlinCsvTypedCsvData::propertyString1_0,
        "propertyString1_1" to KotlinCsvTypedCsvData::propertyString1_1,
        "propertyString1_2" to KotlinCsvTypedCsvData::propertyString1_2,
        "propertyString1_3" to KotlinCsvTypedCsvData::propertyString1_3,
        "propertyString2_0" to KotlinCsvTypedCsvData::propertyString2_0,
        "propertyString2_1" to KotlinCsvTypedCsvData::propertyString2_1,
        "propertyString2_2" to KotlinCsvTypedCsvData::propertyString2_2,
        "propertyString2_3" to KotlinCsvTypedCsvData::propertyString2_3,
        "propertyString3_0" to KotlinCsvTypedCsvData::propertyString3_0,
        "propertyString3_1" to KotlinCsvTypedCsvData::propertyString3_1,
        "propertyString3_2" to KotlinCsvTypedCsvData::propertyString3_2,
        "propertyString3_3" to KotlinCsvTypedCsvData::propertyString3_3,
        "propertyString4_0" to KotlinCsvTypedCsvData::propertyString4_0,
        "propertyString4_1" to KotlinCsvTypedCsvData::propertyString4_1,
        "propertyString4_2" to KotlinCsvTypedCsvData::propertyString4_2,
        "propertyString4_3" to KotlinCsvTypedCsvData::propertyString4_3,
        "propertyString5_0" to KotlinCsvTypedCsvData::propertyString5_0,
        "propertyString5_1" to KotlinCsvTypedCsvData::propertyString5_1,
        "propertyString5_2" to KotlinCsvTypedCsvData::propertyString5_2,
        "propertyString5_3" to KotlinCsvTypedCsvData::propertyString5_3,
        "propertyString6_0" to KotlinCsvTypedCsvData::propertyString6_0,
        "propertyString6_1" to KotlinCsvTypedCsvData::propertyString6_1,
        "propertyString6_2" to KotlinCsvTypedCsvData::propertyString6_2,
        "propertyString6_3" to KotlinCsvTypedCsvData::propertyString6_3,
        "propertyString7_0" to KotlinCsvTypedCsvData::propertyString7_0,
        "propertyString7_1" to KotlinCsvTypedCsvData::propertyString7_1,
        "propertyString7_2" to KotlinCsvTypedCsvData::propertyString7_2,
        "propertyString7_3" to KotlinCsvTypedCsvData::propertyString7_3,
        "localDate0" to KotlinCsvTypedCsvData::localDate0,
        "localDate1" to KotlinCsvTypedCsvData::localDate1,
        "localDateTime0" to KotlinCsvTypedCsvData::localDateTime0,
        "localDateTime1" to KotlinCsvTypedCsvData::localDateTime1,
        "OffsetDateTime0" to KotlinCsvTypedCsvData::offsetDateTime0,
        "OffsetDateTime1" to KotlinCsvTypedCsvData::offsetDateTime1,
    )
}
