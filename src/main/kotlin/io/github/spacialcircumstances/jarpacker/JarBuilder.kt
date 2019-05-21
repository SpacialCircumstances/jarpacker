package io.github.spacialcircumstances.jarpacker

import java.io.File
import java.nio.file.Files
import java.nio.file.StandardOpenOption
import java.util.jar.Attributes
import java.util.jar.JarOutputStream
import java.util.jar.JarEntry
import java.util.jar.Manifest


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
    val outStream = Files.newOutputStream(outFile.toPath(), StandardOpenOption.CREATE)
    val manifest = Manifest()
    manifest.mainAttributes[Attributes.Name.MANIFEST_VERSION] = "1.0"
    val jarStream = JarOutputStream(outStream, manifest)
    files.forEach {
        writeToJar(jarStream, it, sb)
    }
    jarStream.close()
    sb.appendln("JAR ${outFile.path} completed")
    return sb.toString()
}

fun writeToJar(jarStream: JarOutputStream, file: File, logger: StringBuilder) {
    jarStream.putNextEntry(JarEntry(file.name))
    val inStream = Files.newInputStream(file.toPath())
    val buffer = ByteArray(1024)
    while (true) {
        val count = inStream.read(buffer)
        if (count == -1) break
        jarStream.write(buffer, 0, count)
    }
    logger.appendln("File ${file.name} written to JAR")
    jarStream.closeEntry()
}
