package io.github.spacialcircumstances.jarpacker

import java.io.File

fun buildJar(files: List<File>, outFile: File): String {
    val sb = StringBuilder()
    if (outFile.exists()) {
        outFile.delete()
        sb.appendln("File ${outFile.path} deleted.")
    }
    files.forEach {
        if (it.exists()) {
            sb.appendln("File ${it.path} found. Great!")
        } else {
            sb.appendln("File ${it.path} not found. Aborting.")
            return sb.toString()
        }
    }
    return sb.toString()
}