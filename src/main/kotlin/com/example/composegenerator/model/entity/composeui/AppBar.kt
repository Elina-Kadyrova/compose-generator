package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Document

class AppBar(document: Document) : View(document) {
    companion object {
        const val KEY = "app_bar"
    }
    override fun isShown() = false

}