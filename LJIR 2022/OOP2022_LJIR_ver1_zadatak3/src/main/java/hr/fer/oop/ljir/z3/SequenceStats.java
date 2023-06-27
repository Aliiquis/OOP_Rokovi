package hr.fer.oop.ljir.z3;

import java.util.List;
import java.util.stream.Stream;

public class SequenceStats {
    public static int totalSeqLength(List<Sequence> seqList) {
        return seqList.stream()
                .mapToInt(sq -> sq.getSequence().length())
                .sum();
    }

    public static List<String> seqNames(Stream<Sequence> seqList) {
        return seqList.map(Sequence::getName).toList();
    }

    public static double avgQuality(List<Sequence> seqList) {
        return seqList.stream()
                .mapToDouble(Sequence::avgSeqQuality)
                .average()
                .orElse(0);
    }

    // Sequences with Quality above threshold
    public static Stream<Sequence> usableSequences(List<Sequence> seqList, double thqual) {
        return seqList.stream()
                .filter(sq -> sq.avgSeqQuality() > thqual)
                .map(sq -> new Sequence(sq.getName(), sq.getSequence(), ""));
    }

}
