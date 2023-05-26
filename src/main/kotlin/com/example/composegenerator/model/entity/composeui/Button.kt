package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Document

class Button(document: Document) : TextView(document) {
    companion object {
        const val KEY = "button"
    }

    override fun isShown() = true
}