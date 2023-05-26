package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Document
import com.example.composegenerator.model.util.Composable

class Screen(document: Document) : ViewGroup(document, null) {
    override fun isShown() = true
    var elements: MutableList<Composable> = mutableListOf()
}