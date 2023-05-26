package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Document

class FloatingActionButton(document: Document) : View(document) {
    companion object {
        const val KEY = "fab"
    }
    override fun isShown() = true
}
