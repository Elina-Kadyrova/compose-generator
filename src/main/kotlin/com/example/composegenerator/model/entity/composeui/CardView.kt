package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Document


class CardView(document: Document,
               parent: ViewGroup?
) : ViewGroup(document, parent) {
    override fun isShown() = true
}