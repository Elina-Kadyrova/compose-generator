package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Document


class Keyboard(document: Document) : View(document) {
    companion object {
        const val KEY = "keyboard"
    }
    override fun isShown() = false
}
