# jarpacker

A simple application to package files into jarfiles, made for a course at university that required jar files for the exercise solutions.

## Usage

1. Download the application from the "Releases" page
2. Unzip the file
3. Start the application (Windows: Click on the jarpacker.exe in the unzipped directory)
4. Add files to package via the "Add" button (To remove them, guess what button you could use...)
5. Set the output file (either by typing in the path or by clicking the "Open" button)
6. Click on "Create JAR". If the file already exists, you will be asked if you want to override it

## Building

(Tested on JDK8, but might work on later versions)

### JAR

```./gradlew jfxJar``` (use gradlew.bat on Windows)

### Native

```./gradlew jfxNative``` (use gradlew.bat on Windows)
