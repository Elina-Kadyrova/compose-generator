package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Document


class BottomNavigation(document: Document) : View(document) {
    companion object {
        const val KEY = "buttom_nav"
    }

    override fun isShown() = false

}
