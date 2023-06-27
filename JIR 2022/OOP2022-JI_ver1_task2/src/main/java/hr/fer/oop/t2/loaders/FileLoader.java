package hr.fer.oop.t2.loaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileLoader implements DataLoader {

    private String filename;

    public FileLoader(String filename) {
        this.filename = filename;
    }

    @Override
    public Iterable<String> Load() throws NoDataException {
        Path path = Path.of("src", "main", "resources", filename);

        //if the path does not exist throw NoDataException with the message filename does not exist (e.g. data2.txt does not exist)
        if (!Files.exists(path)) throw new NoDataException(filename + " does not exist");
        //if the path exists try to read the file. If an exception happens throw NoDataException with the original exception inside as the exception cause.
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new NoDataException(e);
        }
        List<String> words = new LinkedList<>();
        for (String line : lines) {
            String[] wordsInLine = line.split(" ");
            words.addAll(Arrays.asList(wordsInLine));
        }
        return words;
    }

}
