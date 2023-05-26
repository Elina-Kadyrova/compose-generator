package com.example.composegenerator.plugin_stuff

import com.android.tools.idea.protobuf.Api
import com.example.composegenerator.api.API
import com.example.composegenerator.core.*
import com.example.composegenerator.model.entity.figmaui.NodesResponse
import com.example.composegenerator.plugin_stuff.utils.FileContent
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.PsiManager
import com.intellij.psi.impl.file.PsiDirectoryFactory
import com.example.composegenerator.plugin_stuff.utils.KotlinFileType
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.LocalFileSystem

class GenerateKotlinAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        try {
            val project = event.getData(PlatformDataKeys.PROJECT) ?: return

            val dataContext = event.dataContext
            val module = LangDataKeys.MODULE.getData(dataContext) ?: return

            val directory = when (val navigatable = LangDataKeys.NAVIGATABLE.getData(dataContext)) {
                is PsiDirectory -> navigatable
                is PsiFile -> navigatable.containingDirectory
                else -> {
                    val root = ModuleRootManager.getInstance(module)
                    root.sourceRoots
                        .asSequence()
                        .mapNotNull {
                            PsiManager.getInstance(project).findDirectory(it)
                        }.firstOrNull()
                }
            } ?: return

            val url = Messages.showInputDialog(
                "Enter URL of Figma screen",
                "Generate Compose from Figma",
                null
            )

            val api by kodein.instance<API>()
            val recognizer by kodein.instance<Recognizer>()
            val objectDetector by kodein.instance<ObjectDetector>()
            val filePath = "${project.basePath}/$FILENAME"
            val configFile = LocalFileSystem.getInstance().findFileByPath(filePath)
            val token = configFile.readLines()
            lateinit var response: NodesResponse
            api.getRes(token, getKey(url), getId(url)).subscribe { fileResponse ->
                response = fileResponse
            }

            val detected = objectDetector.recognize(response)
            val recognized = recognizer.recognize(detected)
            val normalizer = Normalizer(recognized)
            val mat = normalizer.normalize()
            val tree = UITreeBuilder().makeTree(mat)

            val code = Generator.generate( tree, "Screen1")

            val fileContent = FileContent(code, getName(response))
            Messages.showYesNoDialog(
                "Need to materialize screen?",
                "Generate Compose from Figma",
                null
            )


            val directoryFactory = PsiDirectoryFactory.getInstance(directory.project)
            val packageName = directoryFactory.getQualifiedName(directory, false)
            val psiFileFactory = PsiFileFactory.getInstance(project)
            val packageDeclare = if (packageName.isNotEmpty()) "package $packageName" else ""
            val file =
                psiFileFactory.createFileFromText("${fileContent.name.trim('`')}.kt", KotlinFileType(), "package " + packageName + "\n\n" + fileContent.content)
            directory.add(file)
        } catch (_: Exception) {}
    }
}

internal val FORBIDDEN_CHARS_REGEX = Regex("[^\\w]")

internal fun String.toValidFileName(): String = this.replace(FORBIDDEN_CHARS_REGEX, "_")


