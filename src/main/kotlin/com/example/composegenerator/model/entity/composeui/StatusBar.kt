package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Document


class StatusBar(document: Document) : View(document) {
    companion object {
        const val KEY = "toolbar"
    }
    override fun isShown() = false
}