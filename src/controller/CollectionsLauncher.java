package controller;

import model.WordSet;

public class CollectionsLauncher {

    public static void main(String[] args) {
        WordSet wordSet = new WordSet();

        wordSet.readFromFile("resources/input.txt");
        System.out.println(wordSet.getNrOfUniqueWords());

        System.out.println(wordSet.getWordsSorted());
    }
}
