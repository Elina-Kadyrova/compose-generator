package com.example.composegenerator.model.entity.figmaui


data class DocumentClass(

    val children: List<Document>,

    val id: String,

    val name: String,

    val type: NodeType,

    val visible: Boolean
)