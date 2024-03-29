package io.github.spacialcircumstances.jarpacker

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.Controller
import java.io.File

class MainController: Controller() {
    val files: ObservableList<String> = FXCollections.observableArrayList()
    val outFile = SimpleStringProperty()
    val logText = SimpleStringProperty()

    fun addFiles(file: List<File>) {
        file.forEach {
            if (it.exists()) {
                files.add(it.path)
            }
        }
    }

    fun removeFile(filename: String) {
        files.remove(filename)
    }

    fun createJar() {
        logText.set("")
        val output = buildJar(files.toList().map(::File), File(outFile.get()))
        logText.set(output)
    }
}