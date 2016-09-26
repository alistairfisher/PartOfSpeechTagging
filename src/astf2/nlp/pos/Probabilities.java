package astf2.nlp.pos;

/**
 * Created by alistair on 23/09/2016.
 */
public class Probabilities {

    static TagBigramCounts tagBigramCounts = TagBigramCounts.getTagBigramCounts();

    static TagWordCounts tagWordCounts = TagWordCounts.getTagWordCounts();

    static double wordGivenTag(String word, Token.Tag tag) {
        int wordCount = tagWordCounts.getCount(tag,word);
        int tagCount = tagBigramCounts.getTotal(tag);
        return wordCount/((double) tagCount);
    }

    static double tagGivenTag(Token.Tag first,Token.Tag second) {
        int firstCount = tagBigramCounts.getTotal(first);
        int bigramCount = tagBigramCounts.getCount(first,second);
        return bigramCount/(double) firstCount;
    }

}
