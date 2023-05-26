package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Document


class SeekBar(document: Document) : View(document) {
    companion object {
        const val KEY = "seek"
    }
    override fun isShown() = true
}
