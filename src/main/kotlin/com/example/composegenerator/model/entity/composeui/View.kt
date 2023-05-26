package com.example.composegenerator.model.entity.composeui

import com.example.composegenerator.model.entity.figmaui.Color
import com.example.composegenerator.model.entity.figmaui.Document
import com.example.composegenerator.model.util.Composable

abstract class View(var document: Document): Composable() {

    companion object {
        val MATCH_PARENT = -1.0
        val WRAP_CONTENT = -2.0
    }

    var id: String = ""
    var x = 0.0
    var y = 0.0
    var layoutHeight = 0.0
    var layoutWidth = 0.0

    var absoluteX: Double = 0.0
    var absoluteY: Double = 0.0
    var height: Double = 0.0
    var width: Double = 0.0

    var backgroundColor: Color? = null
    var radius: Double = 0.0

    var marginTop = 0.0
    var marginStart = 0.0
    var marginEnd = 0.0
    var marginBottom = 0.0

    var paddingTop = 0.0
    var paddingStart = 0.0
    var paddingEnd = 0.0
    var paddingBottom = 0.0

    var constraintTop: String? = null
    var constraintStart: String? = null
    var constraintEnd: String? = null
    var constraintBottom: String? = null

    var layoutConstraintHorizontalBias = 0.5
    var layoutConstraintVerticalBias = 0.5
    abstract fun isShown(): Boolean
}