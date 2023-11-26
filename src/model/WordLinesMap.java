package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Jolien Franke <j.franke@st.hanze.nl>
 * Purpose of program
 */

public class WordLinesMap {

    Map<String, List<Integer>> wordmap = new HashMap<>();

    public void readFromFile(String filename) {
        try (Scanner keyboard = new Scanner(new File(filename))) {
            int lineNumber = 0;
            while (keyboard.hasNextLine()) {
                lineNumber++;

                String nextLine = keyboard.nextLine();
                String[] words = nextLine.split(" ");

                String word;
                int index = 0;
                while (index < words.length) {
                    word = words[index].replaceAll("[^A-Za-z0-9-]", "");

                    List<Integer> lineNumbers = getWordLine(word, lineNumber);

                    wordmap.put(word,lineNumbers);

                    index++;
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println(fileNotFoundException.getMessage());
        }
    }

    private List<Integer> getWordLine(String word, int lineNumber) {
        List<Integer> lineNumbers;
        if (wordmap.containsKey(word)) {
            lineNumbers = wordmap.get(word);

        } else {
            lineNumbers = new ArrayList<>();
        }
        lineNumbers.add(lineNumber);
        return lineNumbers;
    }

    public int getNrOfUniqueWords() {
        return wordmap.size();
    }

    public Iterable<String> getWordsSorted() {
        List<String> sortedWordList = new ArrayList<>();
        for (String word : wordmap.keySet()) {
            sortedWordList.add(word);
        }

        Collections.sort(sortedWordList);

        return sortedWordList;
    }

    public List<Integer> getWordLineNrs(String word) {
        return wordmap.get(word);
    }
}
