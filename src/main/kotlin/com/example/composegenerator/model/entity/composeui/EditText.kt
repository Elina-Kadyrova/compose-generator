package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Document


class EditText(document: Document) : TextView(document) {
    companion object {
        const val KEY = "edit_text"
    }

    override fun isShown() = true
}
