package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Document

class RadioButton(document: Document) : View(document) {
    companion object {
        const val KEY = "radio_button"
    }
    override fun isShown() = true
}
