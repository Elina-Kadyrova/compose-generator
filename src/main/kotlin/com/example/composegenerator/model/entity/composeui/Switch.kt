package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Document

class Switch(document: Document) : View(document) {
    companion object {
        const val KEY = "switch"
    }
    override fun isShown() = true

}
