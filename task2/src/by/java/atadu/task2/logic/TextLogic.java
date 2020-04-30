package by.java.atadu.task2.logic;

import by.java.atadu.task2.composite.Component;
import by.java.atadu.task2.composite.Composite;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        List<String> list = new ArrayList<>();
        int count = 0;
        for (Component paragraph : component.getChild()) {
            for (Component sentence : paragraph.getChild()) {
                for (Component word : sentence.getChild()) {
                    if (word.toString().length() == 0 || list.contains(word.toString())) {
                        continue;
                    }
                    list.add(word.toString());
                    Pattern pattern = Pattern.compile(".*" + word.toString() + ".*", Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(component.toString());
                    while (matcher.find()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
