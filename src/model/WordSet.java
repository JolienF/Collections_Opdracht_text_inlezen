package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordSet {

    Set<String> wordSet = new HashSet<>();

    public void readFromFile(String filename) {

        try (Scanner keyboard = new Scanner(new File(filename))) {
            while (keyboard.hasNext()) {
                String nextWord = keyboard.next();
                nextWord = nextWord.replaceAll("[^A-Za-z0-9-]", "");
                wordSet.add(nextWord);

                keyboard.next();
            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println(fileNotFoundException.getMessage());
        }
    }

    public int getNrOfUniqueWords() {
        return wordSet.size();
    }

    public Iterable<String> getWordsSorted() {
        List<String> sortedWordList = new ArrayList<>(wordSet);
        Collections.sort(sortedWordList);

        return sortedWordList;
    }
}
