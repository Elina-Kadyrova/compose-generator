package com.example.composegenerator.core

import com.example.composegenerator.model.util.UITree

class Generator {

    companion object {
        fun generate(tree: UITree, name: String): String {
            var result = ""
            result += buildInvocation(name)
            tree.map { result += it.generate() }
            result += "\n}"
            return result
        }

        private fun buildInvocation(name: String): String {
            return "@Composable\n $name () {\n"
        }
    }
}