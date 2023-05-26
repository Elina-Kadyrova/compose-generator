package com.example.composegenerator.model.entity.figmaui

import com.google.gson.annotations.SerializedName

enum class StrokeAlign {
    @SerializedName("CENTER")
    Center,

    @SerializedName("INSIDE")
    Inside,

    @SerializedName("OUTSIDE")
    Outside;
}