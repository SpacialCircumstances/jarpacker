package io.github.spacialcircumstances.jarpacker

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.Controller
import java.io.File

class MainController: Controller() {
    val files: ObservableList<String> = FXCollections.observableArrayList()

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