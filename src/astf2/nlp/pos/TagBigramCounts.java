package astf2.nlp.pos;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alistair on 20/09/2016.
 */
public class TagBigramCounts {

    //use as a singleton

    private TagBigramCounts(){
        tagBigramCounts = new EnumMap<>(Token.Tag.class);
        for (Token.Tag t: Token.Tag.values()) {
            EnumMap<Token.Tag,Integer> innermap = new EnumMap<>(Token.Tag.class);
            for (Token.Tag t2: Token.Tag.values()) {
                innermap.put(t2,0);
            }
            tagBigramCounts.put(t,innermap);
        }
        tagTotals = new EnumMap<>(Token.Tag.class);
        for (Token.Tag t2: Token.Tag.values()) {
            tagTotals.put(t2,0);
        }
    }

    private static final TagBigramCounts instance = new TagBigramCounts();

    public static TagBigramCounts getTagBigramCounts() {
        return instance;
    }

    private EnumMap<Token.Tag, EnumMap<Token.Tag,Integer>> tagBigramCounts;

    private EnumMap<Token.Tag, Integer> tagTotals;

    int getCount(Token.Tag first, Token.Tag second) {
        EnumMap<Token.Tag,Integer> map = tagBigramCounts.get(first);
        if (!map.containsKey(second)) {
            return 0;
        }
        else {
            return map.get(second);
        }
    }

    int getTotal(Token.Tag tag) {
        return tagTotals.get(tag);
    }

    private void incrementCount(Token.Tag tag,EnumMap<Token.Tag,Integer> map) {
        map.put(tag,(map.get(tag))+1);
    }

    void addFollow(Token.Tag first, Token.Tag second) {
        incrementCount(first,tagTotals);
        incrementCount(second,tagBigramCounts.get(first));
    }

}
