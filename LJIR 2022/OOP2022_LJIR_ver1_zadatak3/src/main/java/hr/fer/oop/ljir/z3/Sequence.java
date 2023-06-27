package hr.fer.oop.ljir.z3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class Sequence {

    private String name;
    private String sequence;
    private String quality;

    public Sequence(String name, String sequence, String quality) {
        super();
        this.name = name;
        this.sequence = sequence;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public String getSequence() {
        return sequence;
    }

    public String getQuality() {
        return quality;
    }

    public String toString() {
        return "---SEQUENCE---\n"
                + "Name: " + this.name + "\n"
                + "Seq : " + this.sequence + "\n"
                + "Qual: " + this.quality + "\n";
    }

    public boolean equals(Object other) {
        if (!(other instanceof Sequence)) return false;
        Sequence otherSeq = (Sequence) other;

        if (!this.name.equals(otherSeq.getName())) return false;
        if (!this.sequence.equals(otherSeq.getSequence())) return false;
        if (!this.quality.equals(otherSeq.getQuality())) return false;
        return true;
    }

    public double avgSeqQuality() {
        double sum = 0;
        for (Character c : quality.toCharArray()) {
            sum += (int) c;
        }
        return sum / quality.length();
    }

    public static List<Sequence> loadFromFile(String path) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Path.of(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Sequence> list = new LinkedList<>();
        for (int i = 0; i < lines.size(); i += 4) {
            String name = lines.get(i).substring(1);
            String sequence = lines.get(i + 1);
            String quality = lines.get(i + 3);
            list.add(new Sequence(name, sequence, quality));
        }
        return list;
    }
}
