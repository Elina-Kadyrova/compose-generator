package com.example.composegenerator.model.util

import com.github.fimose.converters.*

private var tabsCounter = 1
abstract class Composable {
    var children = mutableListOf<Composable>()

    fun map(f: (Composable) -> Unit) {
        f(this)
        for (child in children) {
            child.map(f)
        }
    }

    fun generate(): String {
        var result = "${Names.get(this)} (${Modifiers.show(this, tabsCount)}, ${Parameters.show(this, tabsCount)}) "
        var childrenGen = ""
        for (child in children) {
            childrenGen += child.generate()
        }
        return result
    }
}