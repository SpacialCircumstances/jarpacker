package io.github.spacialcircumstances.jarpacker

import javafx.collections.FXCollections
import tornadofx.Controller
import java.io.File

class MainController: Controller() {
    val files = FXCollections.observableArrayList<String>("Test.txt")

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
}