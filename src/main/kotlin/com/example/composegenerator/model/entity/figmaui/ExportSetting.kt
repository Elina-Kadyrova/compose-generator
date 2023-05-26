package ru.kpfu.easyxml.modules.entities.figma

import com.example.composegenerator.model.entity.figmaui.Constraint
import com.google.gson.annotations.SerializedName

data class ExportSetting(

    val constraint: Constraint,

    val format: Format,

    val suffix: String
) {

    enum class Format {
        @SerializedName("JPG")
        Jpg,

        @SerializedName("PNG")
        PNG,

        @SerializedName("SVG")
        SVG;
    }
}