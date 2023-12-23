package com.github.momosetkn.csv.individual

import com.fasterxml.jackson.annotation.JsonIgnore
import com.github.momosetkn.com.github.momosetkn.csv.ICsv
import com.github.momosetkn.com.github.momosetkn.csv.ITypedCsvData
import com.orangesignal.csv.annotation.CsvColumn
import com.orangesignal.csv.annotation.CsvEntity
import com.orangesignal.csv.manager.CsvManagerFactory
import java.io.InputStream
import java.io.OutputStream
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.OffsetDateTime


class OrangeSignalExample : ICsv {
    private val csvManager = CsvManagerFactory.newCsvManager()
    override fun <E> readEach(inputStream: InputStream, block: (ITypedCsvData) -> E) {
        // 以下エラーになり無理でした…
        // Exception in thread "main" java.io.IOException: Cannot create com.github.momosetkn.csv.individual.OrangeSignalTypedCsvData: com.github.momosetkn.csv.individual.OrangeSignalTypedCsvData
        val list = csvManager
            .load(OrangeSignalTypedCsvData::class.java)
            .from(inputStream)
        list.forEach {
            block(it)
        }
    }

    override fun <E> writeEach(outputStream: OutputStream, inputIterator: Iterator<E>, block: (E) -> ITypedCsvData) {
        val list = inputIterator.asSequence().map {
            block(it).copyToOther(OrangeSignalTypedCsvData::class)
        }.toList()
        csvManager
            .save(list, OrangeSignalTypedCsvData::class.java)
            .to(outputStream)
    }
}

@CsvEntity
data class OrangeSignalTypedCsvData(
    @CsvColumn(name = "propertyInt0") override val propertyInt0: Int,
    @CsvColumn(name = "propertyInt1") override val propertyInt1: Int,
    @CsvColumn(name = "propertyLong0") override val propertyLong0: Long,
    @CsvColumn(name = "propertyLong1") override val propertyLong1: Long,
    @CsvColumn(name = "propertyFloat0") override val propertyFloat0: Float,
    @CsvColumn(name = "propertyFloat1") override val propertyFloat1: Float,
    @CsvColumn(name = "propertyDouble0") override val propertyDouble0: Double,
    @CsvColumn(name = "propertyDouble1") override val propertyDouble1: Double,
    @CsvColumn(name = "propertyString0_0") override val propertyString0_0: String,
    @CsvColumn(name = "propertyString0_1") override val propertyString0_1: String,
    @CsvColumn(name = "propertyString0_2") override val propertyString0_2: String,
    @CsvColumn(name = "propertyString0_3") override val propertyString0_3: String,
    @CsvColumn(name = "propertyString1_0") override val propertyString1_0: String,
    @CsvColumn(name = "propertyString1_1") override val propertyString1_1: String,
    @CsvColumn(name = "propertyString1_2") override val propertyString1_2: String,
    @CsvColumn(name = "propertyString1_3") override val propertyString1_3: String,
    @CsvColumn(name = "propertyString2_0") override val propertyString2_0: String,
    @CsvColumn(name = "propertyString2_1") override val propertyString2_1: String,
    @CsvColumn(name = "propertyString2_2") override val propertyString2_2: String,
    @CsvColumn(name = "propertyString2_3") override val propertyString2_3: String,
    @CsvColumn(name = "propertyString3_0") override val propertyString3_0: String,
    @CsvColumn(name = "propertyString3_1") override val propertyString3_1: String,
    @CsvColumn(name = "propertyString3_2") override val propertyString3_2: String,
    @CsvColumn(name = "propertyString3_3") override val propertyString3_3: String,
    @CsvColumn(name = "propertyString4_0") override val propertyString4_0: String,
    @CsvColumn(name = "propertyString4_1") override val propertyString4_1: String,
    @CsvColumn(name = "propertyString4_2") override val propertyString4_2: String,
    @CsvColumn(name = "propertyString4_3") override val propertyString4_3: String,
    @CsvColumn(name = "propertyString5_0") override val propertyString5_0: String,
    @CsvColumn(name = "propertyString5_1") override val propertyString5_1: String,
    @CsvColumn(name = "propertyString5_2") override val propertyString5_2: String,
    @CsvColumn(name = "propertyString5_3") override val propertyString5_3: String,
    @CsvColumn(name = "propertyString6_0") override val propertyString6_0: String,
    @CsvColumn(name = "propertyString6_1") override val propertyString6_1: String,
    @CsvColumn(name = "propertyString6_2") override val propertyString6_2: String,
    @CsvColumn(name = "propertyString6_3") override val propertyString6_3: String,
    @CsvColumn(name = "propertyString7_0") override val propertyString7_0: String,
    @CsvColumn(name = "propertyString7_1") override val propertyString7_1: String,
    @CsvColumn(name = "propertyString7_2") override val propertyString7_2: String,
    @CsvColumn(name = "propertyString7_3") override val propertyString7_3: String,
    @CsvColumn(name = "localDate0") override val localDate0: LocalDate,
    @CsvColumn(name = "localDate1") override val localDate1: LocalDate,
    @CsvColumn(name = "localDateTime0") override val localDateTime0: LocalDateTime,
    @CsvColumn(name = "localDateTime1") override val localDateTime1: LocalDateTime,
    @CsvColumn(name = "OffsetDateTime0") override val offsetDateTime0: OffsetDateTime,
    @CsvColumn(name = "OffsetDateTime1") override val offsetDateTime1: OffsetDateTime,
) : ITypedCsvData
