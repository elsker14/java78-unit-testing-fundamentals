package org.example.file_ops;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperations {

    private final String fileName;

    public FileOperations(String fileName) {
        this.fileName = "src/main/resources/" + fileName;
    }

    public boolean createFile() throws IOException {
        File file = new File(fileName);
        return file.createNewFile();
    }

    public void writeInFile(String content) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        fw.write(content);
        fw.close();
    }

    public String readFromFile() throws IOException {
        return Files.readString(Paths.get(fileName));
    }

    public void cleanup() throws IOException {
        Files.deleteIfExists(Paths.get(fileName));
    }

    public String getFileName() {
        return fileName;
    }
}
