package io.github.spacialcircumstances.jarpacker

import javafx.beans.property.SimpleStringProperty
import javafx.stage.FileChooser
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
                    val file = chooseFile("Add files to JAR file", filters = emptyArray(), mode = FileChooserMode.Multi)
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
        hbox {
            label("Ausgabedatei:")
            textfield(controller.outFile) {

            }
            button {
                text = "Open"
                action {
                    val saveFile = chooseFile("JAR file destination", filters = arrayOf(FileChooser.ExtensionFilter("JAR", "jar")), mode = FileChooserMode.Save)
                    controller.outFile.set(saveFile.single().path)
                }
            }

            button {
                text = "Create JAR"
                disableProperty().bind(controller.outFile.isEmpty.or(filesSelected))
                action {

                }
            }
        }
        textarea(controller.logText) {
            isEditable = false
        }
    }
}