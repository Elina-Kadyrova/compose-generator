package com.example.composegenerator.model.entity.figmaui

import com.google.gson.annotations.SerializedName

data class File(
    val key: String,

    @SerializedName(value = "last_modified")
    val lastModified: String,

    val name: String,

    @SerializedName(value = "thumbnail_url")
    val thumbnailURL: String
)