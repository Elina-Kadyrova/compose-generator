package com.example.composegenerator.model.entity.figmaui

import com.google.gson.annotations.SerializedName


data class TypeStyle(
    val fills: List<Paint>,

    val fontFamily: String,

    val fontPostScriptName: String,

    val fontSize: Double,

    val fontWeight: Double,

    val italic: Boolean,

    val letterSpacing: Double,

    val lineHeightPercent: Double,

    val lineHeightPx: Double,

    val textAlignHorizontal: TextAlignHorizontal,

    val textAlignVertical: TextAlignVertical,

    @SerializedName("textCase")
    val _textCase: TextCase?,

    @SerializedName("textDecoration")
    val _textDecoration: TextDecoration?
) {

    val textCase: TextCase
        get() = _textCase ?: TextCase.ORIGINAL

    val textDecoration: TextDecoration
        get() = _textDecoration ?: TextDecoration.NONE

    /**
     * Vertical text alignment as string enum
     */
    enum class TextAlignVertical {
        @SerializedName("BOTTOM")
        BOTTOM,

        @SerializedName("CENTER")
        CENTER,

        @SerializedName("TOP")
        TOP;
    }

    /**
     * Horizontal text alignment as string enum
     */
    enum class TextAlignHorizontal {
        @SerializedName("CENTER")
        CENTER,

        @SerializedName("JUSTIFIED")
        JUSTIFIED,

        @SerializedName("LEFT")
        LEFT,

        @SerializedName("RIGHT")
        RIGHT;
    }

    /**
     *  Text case as enum
     */
    enum class TextCase {
        @SerializedName("ORIGINAL")
        ORIGINAL,

        @SerializedName("UPPER")
        UPPER,

        @SerializedName("LOWER")
        LOWER,

        @SerializedName("TITLE")
        TITLE
    }

    /**
     * Decoration of text as enum
     */
    enum class TextDecoration {
        @SerializedName("NONE")
        NONE,

        @SerializedName("STRIKETHROUGH")
        STRIKETHROUGH,

        @SerializedName("UNDERLINE")
        UNDERLINE
    }
}