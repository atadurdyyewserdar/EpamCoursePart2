package by.java.atadu.task2.logic;

import by.java.atadu.task2.composite.Component;

import java.util.*;

public class TextLogic {
    private Component clone(Component component) {
        return null;
    }

    public void sortParagraphBySentenceCount(Component component) {
        List<Component> componentList = component.getChild();
        componentList.sort(Comparator.comparingInt(paragraph -> paragraph.getChild().size()));
    }

    public String findLongestWord(Component component) {
        boolean isZeroIndex = false;
        String currWord = "";
        String result = "";

        for (Component paragraph : component.getChild()) { // paragraphs
            for (Component sentence : paragraph.getChild()) { //sentences
                for (Component word : sentence.getChild()) { //words
                    if (!isZeroIndex) {
                        currWord = word.toString();
                        result = sentence.toString();
                        isZeroIndex = true;
                        continue;
                    }
                    if (word.toString().length() > currWord.length()) {
                        currWord = word.toString();
                        result = sentence.toString();
                    }
                }
            }
        }
        return result;
    }

    public void deleteSentence(int count, Component component) {
        //TODO
    }

    public int countSimilarWords(Component component) {
        //TODO
        return 0;
    }
}
