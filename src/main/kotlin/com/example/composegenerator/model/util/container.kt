package com.example.composegenerator.model.util

class Row(
    modifiers: List<Pair<String, String>> = listOf(),
    params: List<Pair<String, String>> = listOf(),
    alignment: VerticalAlignment = VerticalAlignment.Start,
    arrangement: Arrangement = Arrangement.Start
): UITree()

class Column(
    modifiers: List<Pair<String, String>> = listOf(),
    params: List<Pair<String, String>> = listOf(),
    alignment: HorisontalAlignment = HorisontalAlignment.Start,
    arrangement: Arrangement = Arrangement.Start
): UITree()

enum class Arrangement {
    SpaceEvently,
    SpaceBetween,
    SpaceAround,
    Center,
    Start,
    End
}

enum class VerticalAlignment {
    Center,
    Start,
    Left
}

enum class HorisontalAlignment {
    Center,
    Start,
    Left
}