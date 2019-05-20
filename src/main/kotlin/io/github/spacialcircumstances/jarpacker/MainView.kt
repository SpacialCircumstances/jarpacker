package io.github.spacialcircumstances.jarpacker

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class MainView: View() {
    val controller: MainController by inject()
    val selectedFile = SimpleStringProperty()
    val filesSelected = controller.files.sizeProperty.eq(0)

    override val root = vbox {
        listview(controller.files).bindSelected(selectedFile)
        hbox {
            button {
                text = "Add"
                action {
                    val file = chooseFile("Add files to jar file", filters = emptyArray(), mode = FileChooserMode.Multi)
                    controller.addFiles(file)
                }
            }

            button {
                disableProperty().bind(filesSelected)
                text = "Remove"
                action {
                    val selected = selectedFile.get()
                    if (selected != null) {
                        controller.removeFile(selected)
                    }
                }
            }
        }
    }
}