package com.example.composegenerator.model.entity.figmaui

import com.google.gson.annotations.SerializedName

/**
 * Horizontal and vertical layout constraints for node
 *
 * Layout constraint relative to containing Frame
 */
data class LayoutConstraint(
    val horizontal: Horizontal,
    val vertical: Vertical
) {

    enum class Horizontal {
        @SerializedName("MIXED")
        Mixed,

        @SerializedName("CENTER")
        Center,

        @SerializedName("LEFT")
        Left,

        @SerializedName("LEFT_RIGHT")
        LeftRight,

        @SerializedName("RIGHT")
        Right,

        @SerializedName("SCALE")
        Scale;
    }

    enum class Vertical {
        @SerializedName("MIXED")
        Mixed,

        @SerializedName("BOTTOM")
        Bottom,

        @SerializedName("CENTER")
        Center,

        @SerializedName("SCALE")
        Scale,

        @SerializedName("TOP")
        Top,

        @SerializedName("TOP_BOTTOM")
        TopBottom;
    }
}