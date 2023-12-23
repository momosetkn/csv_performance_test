package com.github.momosetkn.com.github.momosetkn.csv

import com.github.momosetkn.csv.individual.KotlinCsvExample
import com.github.momosetkn.csv.individual.OrangeSignalExample

enum class CsvLibraryType {
    OrangeSignal,
    KotlinCsv,
}

fun csvReaderFactory(type: CsvLibraryType): ICsv {
    return  when(type){
        CsvLibraryType.OrangeSignal -> OrangeSignalExample()
        CsvLibraryType.KotlinCsv -> KotlinCsvExample()
    }
}
