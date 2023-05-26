package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Document

open class ViewGroup(
    document: Document,
    var parent: ViewGroup?
) : View(document) {
    override fun isShown() = true
}