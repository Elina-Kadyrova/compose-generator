package com.example.composegenerator.model.entity.figmaui

import com.google.gson.annotations.SerializedName


data class LayoutGrid(

    val alignment: Alignment,

    val color: Color,

    val count: Double,

    val gutterSize: Double,

    val offset: Double,

    val pattern: Pattern,

    val sectionSize: Double,

    val visible: Boolean
) {

    enum class Pattern {
        @SerializedName("COLUMNS")
        Columns,

        @SerializedName("GRID")
        Grid,

        @SerializedName("ROWS")
        Rows;
    }

    enum class Alignment {
        @SerializedName("CENTER")
        Center,

        @SerializedName("MAX")
        Max,

        @SerializedName("MIN")
        Min;
    }
}