package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Document


open class TextView(document: Document) : View(document) {
    override fun isShown() = true
}