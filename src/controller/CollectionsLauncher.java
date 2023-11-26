package controller;

import model.WordLinesMap;
import model.WordSet;

public class CollectionsLauncher {

    public static void main(String[] args) {
        WordSet wordSet = new WordSet();
        WordLinesMap wordmap = new WordLinesMap();

//        wordSet.readFromFile("resources/input.txt");
//        System.out.println(wordSet.getNrOfUniqueWords());
//
//        System.out.println(wordSet.getWordsSorted());

        wordmap.readFromFile("resources/input.txt");
    }
}
