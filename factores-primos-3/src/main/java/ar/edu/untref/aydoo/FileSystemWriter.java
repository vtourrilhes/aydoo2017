package ar.edu.untref.aydoo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileSystemWriter {

    public FileSystemWriter() {

    }

    public boolean makeFile(String fileName) throws IOException {

        List<String> lines = Arrays.asList("The first line", "The second line");
        Path file = Paths.get("the-file-name.txt");
        Files.write(file, lines, Charset.forName("UTF-8"));

        return false;
    }
}
