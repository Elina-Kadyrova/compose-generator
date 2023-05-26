package com.example.composegenerator.di

import com.example.composegenerator.core.ObjectDetector
import com.example.composegenerator.core.Recognizer
import com.example.composegenerator.di.modules.apiModule
import org.kodein.di.DI
import org.kodein.di.bindSingleton

val di = DI {
    import(apiModule)

    bindSingleton<Recognizer>("rec") { Recognizer() }
    bindSingleton<ObjectDetector>("neural") { ObjectDetector() }
}