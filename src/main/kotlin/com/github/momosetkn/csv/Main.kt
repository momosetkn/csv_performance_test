package com.github.momosetkn.com.github.momosetkn.csv

import com.github.momosetkn.csv.data.GenerateData
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

const val COUNT = 1_000_000

fun main(vararg args: String) {
    val readWriterType = args[0]
    val csvLiv = args[1]
    val csvLibraryType = CsvLibraryType.valueOf(csvLiv)

    val startTime = System.nanoTime()
    when (readWriterType) {
        "read" -> read(csvLibraryType)
        "write" -> write(csvLibraryType)
    }

    val endTime = System.nanoTime()
    println("time: ${(endTime - startTime) / 1_000_000_000.0} sec")
}

fun read(csvLib: CsvLibraryType) {
    val file = File(DIRECTORY).resolve("${csvLib.name}.csv")
    csvReaderFactory(csvLib)
        .readEach(FileInputStream(file)) {
            ;// nope
        }
}

fun write(csvLib: CsvLibraryType) {
    val ite = generateSequence { GenerateData.testTypedCsvData() }.take(COUNT)
    val file = File(DIRECTORY).resolve("${csvLib.name}.csv")
    csvReaderFactory(csvLib)
        .writeEach(FileOutputStream(file), ite.iterator()) {
            it
        }
}

const val DIRECTORY = "/mytmpfs/"
