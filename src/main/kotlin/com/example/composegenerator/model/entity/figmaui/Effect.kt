package com.example.composegenerator.model.entity.figmaui

import com.google.gson.annotations.SerializedName


data class Effect(

    val blendMode: BlendMode? = null,

    val color: Color? = null,

    val offset: Vector2? = null,

    val radius: Double,

    val type: EffectType,

    val visible: Boolean
) {

    enum class EffectType {
        @SerializedName("BACKGROUND_BLUR")
        BackgroundBlur,

        @SerializedName("DROP_SHADOW")
        DropShadow,

        @SerializedName("INNER_SHADOW")
        InnerShadow,

        @SerializedName("LAYER_BLUR")
        LayerBlur;
    }
}