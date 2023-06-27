package hr.fer.oop.zad3;

import java.util.List;
import java.util.stream.Stream;

public class SequenceStats {
    public static int maxSeqLength(List<Sequence> seqList) {
        return seqList.stream()
                .mapToInt(sq -> sq.getSequence().length())
                .max()
                .orElse(0);
    }

    public static List<String> seqNames(List<Sequence> seqList) {
        return seqList.stream()
                .map(Sequence::getName)
                .toList();
    }

    public static double avgGCContent(Stream<Sequence> seqList) {
        return seqList.mapToDouble(Sequence::getGCContent)
                .average()
                .orElse(0.);
    }

    public static Stream<Sequence> usableSequences(List<Sequence> seqList, double thGC) {
        return seqList.stream()
                .filter(sq -> sq.getGCContent() > thGC)
                .map(sq -> new Sequence(sq.getName(), sq.getSequence(), ""));
    }

}
