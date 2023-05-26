package com.example.composegenerator.core

import com.example.composegenerator.model.util.Column
import com.example.composegenerator.model.util.Composable
import com.example.composegenerator.model.util.Row
import com.example.composegenerator.model.util.UITree


class UITreeBuilder {

    fun makeTree(elements: MutableList<Composable>): UITree {
        if (elements.size == 0) return Row()
        val separated = separateByConstraint(elements)
        val col = Column()
        val row = Row()
        col.children = rearrange(separated.first)
        return makeTree((col.children + rearrange(separated.second)).toMutableList())
    }

    private fun separateByConstraint(elements: MutableList<Composable>): Pair<MutableList<Composable>, MutableList<Composable>> {
        val res = Pair(mutableListOf<Composable>(), mutableListOf<Composable>())
        for (element in elements) {
            if (element.constraintStart != null) {
                res.first.add(element)
            } else res.second.add(element)
        }
        return res
    }

    private fun rearrange(elements: MutableList<Composable>): MutableList<Composable> {
        elements.sortWith(
            comparator = Comparator { it: Composable, other: Composable ->
                (it.absoluteX + it.absoluteY - other.absoluteX - other.absoluteY).toInt()
            }
        )
        return elements
    }
}