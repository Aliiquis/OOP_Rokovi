package hr.fer.oop.t2;

import hr.fer.oop.t2.loaders.DataLoader;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Counter {
    private Map<String, Integer> words = new TreeMap<>();
    private int exceptionsCount = 0;

    public Map<String, Integer> getWords() {
        return Collections.unmodifiableMap(words);
    }

    public int getExceptionsCount() {
        return exceptionsCount;
    }

    public void process(DataLoader loader) {
        //TO DO:
        //Take strings using loader, increase occurance of each string
        //in case of an exception, increase exception count.
        try {
            for (String word : loader.Load()) {
                words.merge(word, 1, Integer::sum);
            }
        } catch (Exception e) {
            exceptionsCount++;
        }
    }
}
