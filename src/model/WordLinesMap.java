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

                    List<Integer> lineNumbers;
                    if (wordmap.containsKey(word)) {
                        lineNumbers = wordmap.get(word);

                    } else {
                        lineNumbers = new ArrayList<>();
                    }
                    lineNumbers.add(lineNumber);

                    wordmap.put(word,lineNumbers);

                    index++;
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println(fileNotFoundException.getMessage());
        }
    }

    public int getNrOfUniqueWords() {
        return 0;

    }

    public Iterable<String> getWordsSorted() {

        return null;
    }

    public List<Integer> getWordLineNrs(String word) {

        return null;
    }


}
