package com.github.momosetkn.csv.confirmbug

import com.github.momosetkn.com.github.momosetkn.csv.CsvLibraryType
import com.github.momosetkn.com.github.momosetkn.csv.csvReaderFactory
import com.github.momosetkn.csv.data.GenerateData
import java.io.ByteArrayOutputStream
import java.nio.charset.StandardCharsets

const val COUNT = 10

/**
 * below error occurred
 *
 * Exception in thread "main" java.lang.NullPointerException
 * 	at io.blackmo18.kotlin.grass.pot.Root.createObject(Root.kt:58)
 * 	at io.blackmo18.kotlin.grass.pot.Stem.harvestData(Stem.kt:48)
 * 	at io.blackmo18.kotlin.grass.pot.Plant.harvest(Plant.kt:42)
 * 	at com.github.momosetkn.csv.individual.KotlinCsvExample.readEach(KotlinCsvTypedCsvData.kt:21)
 * 	at com.github.momosetkn.com.github.momosetkn.csv.confirmbug.ForConfirmBugKt.read(ForConfirmBug.kt:24)
 * 	at com.github.momosetkn.com.github.momosetkn.csv.confirmbug.ForConfirmBugKt.main(ForConfirmBug.kt:15)
 */

fun main(vararg args: String) {
    val startTime = System.nanoTime()

    val csvString = write(CsvLibraryType.KotlinCsv)
    read(CsvLibraryType.KotlinCsv, csvString)

    val endTime = System.nanoTime()
    println("time: ${(endTime - startTime) / 1_000_000_000.0} sec")
}

fun read(csvLib: CsvLibraryType, csvString: String) {
    val inputStream = csvString.byteInputStream(StandardCharsets.UTF_8)
    csvReaderFactory(csvLib)
        .readEach(inputStream) {
            ;// nope
        }
}

fun write(csvLib: CsvLibraryType): String {
    val ite = generateSequence { GenerateData.testTypedCsvData() }.take(COUNT)
    val outputStream = ByteArrayOutputStream()
    csvReaderFactory(csvLib)
        .writeEach(outputStream, ite.iterator())

    return outputStream.toByteArray().toString(StandardCharsets.UTF_8)
}

const val DIRECTORY = "/mytmpfs/"
