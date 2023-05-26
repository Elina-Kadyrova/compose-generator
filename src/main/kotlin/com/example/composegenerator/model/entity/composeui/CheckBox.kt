package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Document


class CheckBox(document: Document) : View(document) {
    companion object {
        const val KEY = "checkbox"
    }
    override fun isShown() = true
}