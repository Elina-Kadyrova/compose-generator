package com.example.composegenerator.model.entity.figmaui

import com.google.gson.annotations.SerializedName

data class ScreenResponse(
    @SerializedName("lastModified")
    val lastModified: String? = null,

    val name: String? = null,

    @SerializedName("thumbnailUrl")
    val thumbnailURL: String? = null,

    val document: Document? = null
)

data class NodesResponse(

    @SerializedName("lastModified")
    val lastModified: String? = null,

    val name: String? = null,

    @SerializedName("thumbnailUrl")
    val thumbnailURL: String? = null,

    val version: String? = null,

    val nodes: Map<String, DocumentWrapper>? = null
) {

    data class DocumentWrapper(
        val document: Document,
        val components: Map<String, Component>? = null
    )
}