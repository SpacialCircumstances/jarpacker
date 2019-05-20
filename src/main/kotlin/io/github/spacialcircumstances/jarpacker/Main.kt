package io.github.spacialcircumstances.jarpacker

import tornadofx.App
import tornadofx.launch

class Application: App(MainView::class)

fun main(args: Array<String>) {
    launch<Application>(args)
}