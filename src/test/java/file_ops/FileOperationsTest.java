package file_ops;

/*
    Write a program that imitates file operations. Then write check tests: file
    creation, write, read, file cleanup. Use lifecycle methods.

    - create File
    - write into File
    - read from File
*/

import org.example.file_ops.FileOperations;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class FileOperationsTest {

    private static final String FILE_NAME = "test.txt";
    private FileOperations fileOps;

    // Before Hook
    @BeforeEach
    public void setup() {
        System.out.println("Setting up file path");
        fileOps = new FileOperations(FILE_NAME);
    }

    @Test
    @DisplayName("Create File Test")
    public void testCreateFile() throws IOException {
        System.out.println("Creating file");
        boolean result = fileOps.createFile();
        assertThat(result)
                .isTrue();
        assertThat(Files.exists(Paths.get(fileOps.getFileName())))
                .isTrue();
    }

    @Test
    @Disabled
    public void testWriteAndReadFile() throws IOException {
        String content = "Hello World!";
        fileOps.createFile();
        fileOps.writeInFile(content);

        String readContent = fileOps.readFromFile();
        assertThat(readContent).isEqualTo(content);
    }

    // After Hook
    @AfterEach
    public void cleanup() throws IOException {
        System.out.println("Cleaning up");
        fileOps.cleanup();
    }
}
