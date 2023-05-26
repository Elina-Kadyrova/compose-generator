package com.example.composegenerator.plugin_stuff

import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import com.intellij.openapi.ui.MessageType
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.ui.popup.Balloon
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.wm.WindowManager
import com.intellij.ui.awt.RelativePoint
import java.io.File
import javax.swing.event.HyperlinkEvent
import javax.swing.event.HyperlinkListener

const val FILENAME = ".token"

class CheckConfigStartupActivity: StartupActivity {
    override fun runActivity(project: Project) {
        DumbService.getInstance(project).runWhenSmart {
            if (needToCreateConfig(project)) {
                suggestCreateConfig(project)
            }
        }
    }

    private fun needToCreateConfig(project: Project): Boolean {
        val filePath = "${project.basePath}/$FILENAME"
        val file = LocalFileSystem.getInstance().findFileByPath(filePath)
        return file == null
    }

    private fun suggestCreateConfig(project: Project) {
        val statusBar = WindowManager.getInstance().getStatusBar(project)
        val factory = JBPopupFactory.getInstance()

        val message = "Figma API key is not set up. <a href = \"setup\">Set Up</a>"

        val hyperlinkListener = HyperlinkListener { e ->
            if (e.eventType == HyperlinkEvent.EventType.ACTIVATED) {
                // Show an input dialog
                createConfig(project)
            }
        }
        factory.createHtmlTextBalloonBuilder(message, MessageType.WARNING, hyperlinkListener)
            .setHideOnAction(true)
            .setHideOnClickOutside(true)
            .createBalloon()
            .show(RelativePoint.getCenterOf(statusBar.component), Balloon.Position.atRight)
    }

    private fun createConfig(project: Project) {
        val filePath = "${project.basePath}/$FILENAME"
        val key = Messages.showInputDialog(
            "Please enter your private Figma API key",
            "CREATE CONFIG FILE",
            Messages.getQuestionIcon()
        )
        if (!key.isNullOrEmpty()) {
                val outputFile = File(filePath)

                outputFile.writeText(key)
        }
    }
}