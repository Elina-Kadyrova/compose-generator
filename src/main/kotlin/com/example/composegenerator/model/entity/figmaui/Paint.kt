package com.example.composegenerator.model.entity.figmaui

import com.google.gson.annotations.SerializedName

data class Paint(

    val color: Color? = null,

    val gradientHandlePositions: List<Vector2>? = null,

    val gradientStops: List<ColorStop>? = null,

    val opacity: Double,

    val scaleMode: String? = null,

    val type: FillType,

    @SerializedName("visible")
    private val _visible: Boolean?
) {

    val visible: Boolean
        get() = _visible ?: true

    enum class FillType {
        @SerializedName("EMOJI")
        Emoji,

        @SerializedName("GRADIENT_ANGULAR")
        GradientAngular,

        @SerializedName("GRADIENT_DIAMOND")
        GradientDiamond,

        @SerializedName("GRADIENT_LINEAR")
        GradientLinear,

        @SerializedName("GRADIENT_RADIAL")
        GradientRadial,

        @SerializedName("IMAGE")
        Image,

        @SerializedName("SOLID")
        Solid;
    }

    data class ColorStop(

        val color: Color,

        val position: Double
    )
}