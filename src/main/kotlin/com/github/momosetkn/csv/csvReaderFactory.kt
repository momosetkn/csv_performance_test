package com.github.momosetkn.com.github.momosetkn.csv

import com.github.momosetkn.csv.individual.OrangeSignalExample

enum class CsvLibraryType {
    OrangeSignal,
}

fun csvReaderFactory(type: CsvLibraryType): ICsv {
    return  when(type){
        CsvLibraryType.OrangeSignal -> OrangeSignalExample()
    }
}
