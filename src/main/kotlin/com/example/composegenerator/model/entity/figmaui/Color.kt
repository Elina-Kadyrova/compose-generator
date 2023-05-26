package com.example.composegenerator.model.entity.figmaui

data class Color(

    var a: Float,

    var b: Float,

    var g: Float,

    var r: Float
) {
    companion object {
        fun getHex(color: Color): String =
            "#${Integer.toHexString(java.awt.Color(color.r, color.g, color.b, color.a).rgb)}"
    }

    fun getHex(): String = "#${Integer.toHexString(java.awt.Color(this.r, this.g, this.b, this.a).rgb)}"

    fun getHex(opacity: Float): String =
        "#${Integer.toHexString(java.awt.Color(this.r * opacity, this.g, this.b, this.a).rgb)}"
}