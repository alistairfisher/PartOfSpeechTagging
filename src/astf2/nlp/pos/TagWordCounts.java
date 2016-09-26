package astf2.nlp.pos;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alistair on 20/09/2016.
 */
public class TagWordCounts {


    private TagWordCounts() {
        tagsToWordsMap = new EnumMap<>(Token.Tag.class);
        for (Token.Tag t: Token.Tag.values()) {
            tagsToWordsMap.put(t,new HashMap<String,Integer>());
        }
    }

    private static final TagWordCounts instance = new TagWordCounts();

    public static TagWordCounts getTagWordCounts() {
        return instance;
    }

    private EnumMap<Token.Tag,Map<String,Integer>> tagsToWordsMap;

    private void incrementCount(Token.Tag tag,String s) {
        Map<String,Integer> wordMap = tagsToWordsMap.get(tag);
        wordMap.put(s,(wordMap.get(s))+1);
    }

    int getCount(Token.Tag tag, String word) {
        Map<String,Integer> wordMap = tagsToWordsMap.get(tag);
        if (!(wordMap.containsKey(word))) {
            return 0;
        }
        else {
            return wordMap.get(word);
        }
    }

    private void addWord(Token.Tag tag, String word) {
        Map<String,Integer> wordMap = tagsToWordsMap.get(tag);
        wordMap.put(word,1);
    }

    void countWord(Token.Tag tag,String word) {
        String trimmedWord = word.trim();
        if (getCount(tag,trimmedWord)==0) {
            addWord(tag,trimmedWord);
        }
        else {
            incrementCount(tag,trimmedWord);
        }
    }

}
