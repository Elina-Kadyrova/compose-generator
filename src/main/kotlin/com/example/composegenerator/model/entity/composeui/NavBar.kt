package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Document

class NavBar(document: Document) : View(document) {
    companion object {
        const val KEY = "nav_bar"
    }
    override fun isShown() = false
}
