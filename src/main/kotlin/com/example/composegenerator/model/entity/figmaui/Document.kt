package com.example.composegenerator.model.entity.figmaui

import com.google.gson.annotations.SerializedName
import ru.kpfu.easyxml.modules.entities.figma.*

data class Document(

    val children: List<Document>? = null,
    val id: String,
    val name: String,
    val type: NodeType,
    @SerializedName("visible")
    private val _visible: Boolean?,
    val backgroundColor: Color? = null,
    val absoluteBoundingBox: Rect? = null,
    var constraints: LayoutConstraint,


    val blendMode: BlendMode? = null,

    val clipsContent: Boolean? = null,

    val exportSettings: List<ExportSetting>? = null,

    val effects: List<Effect>? = null,

    val isMask: Boolean = false,

    val layoutGrids: List<LayoutGrid>? = null,

    @SerializedName("opacity")
    private val _opacity: Float?,

    val preserveRatio: Boolean = false,

    val transitionNodeID: String? = null,

    val fills: List<Paint>? = null,

    val strokeAlign: StrokeAlign? = null,

    val strokes: List<Paint>? = null,

    val strokeWeight: Double? = null,

    val cornerRadius: Double? = null,

    val characters: String? = null,

    val characterStyleOverrides: List<Double>? = null,

    val style: TypeStyle? = null,

    val styleOverrideTable: Map<Number, TypeStyle>? = null,

    val description: String? = null,

    @SerializedName(value = "componentId")
    val componentID: String? = null,

    var fixedConstraint: Boolean = false
) {

    companion object {
        private val images = listOf(
            NodeType.VECTOR,
            NodeType.BOOLEAN,
            NodeType.STAR,
            NodeType.LINE,
            NodeType.ELLIPSE,
            NodeType.REGULAR_POLYGON,
            NodeType.RECTANGLE
        )
    }

    val visible
        get() = _visible ?: true

    val opacity
        get() = _opacity ?: 1F

    var isImage: Boolean = false

    override fun toString(): String = "name=$name type=$type ${super.toString()}"

    fun isImageType(): Boolean = images.contains(type)
}
