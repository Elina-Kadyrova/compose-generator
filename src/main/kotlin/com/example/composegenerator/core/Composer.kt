package com.example.composegenerator.core

import com.example.composegenerator.api.API
import com.example.composegenerator.model.entity.figmaui.NodesResponse
import com.example.composegenerator.plugin_stuff.FILENAME
import com.example.composegenerator.plugin_stuff.utils.FileContent
import com.intellij.openapi.vfs.LocalFileSystem


class Composer {
    fun makeCompose(url: String, needToMat: Int, token: String): FileContent {
        val api by kodein.instance<API>()
        val recognizer by kodein.instance<Recognizer>()
        val objectDetector by kodein.instance<ObjectDetector>()
        val token = configFile.readLines()
        lateinit var response: NodesResponse
        api.getRes(token, getKey(url), getId(url)).subscribe { fileResponse ->
            response = fileResponse
        }
        val detected = objectDetector.recognize(response)
        val recognized = recognizer.recognize(detected)
        val tree = if (needToMat) {
            val mat = Normalizer(recognized).normalize()
            UITreeBuilder().makeTree(mat)
        } else {
            UITreeBuilder().makeTree(recognized)
        }
        val code = Generator.generate( tree, "Screen1")

        return FileContent(code, getName(response))
    }
}