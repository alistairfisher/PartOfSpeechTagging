package astf2.nlp.pos;

import java.util.EnumMap;

/**
 * Created by alistair on 23/09/2016.
 */
public class Viterbi {

    /*The Viterbi 2D array of nodes is indexed by elements of the sentence horizontally and C5 Tags vertically
    Here, it is represented as an array of Enum Maps, each EnumMap is a column of the Viterbi array.
    Nodes contain 2 variables. The first is a double, representing the probability of the most probable path to that
    node through the Viterbi array. The second is a tag, used to look up the previous node in the path, in the previous
    column.
    */

    EnumMap<Token.Tag,Node>[] viterbiArray;

    //The phrase to be tagged
    String[] phrase;

    Viterbi(String[] phrase) {
        this.phrase = phrase;
        this.viterbiArray = new EnumMap[phrase.length];
        this.fillArray();
    }

    double getPrior(Token.Tag tag, int column) {
        return viterbiArray[column].get(tag).Probability;
    }

    double getProbability(Token.Tag current, Token.Tag previous, String word, double Prior) {
        String word2 = word.toLowerCase();
        Double transitionProbability = Probabilities.tagGivenTag(previous,current);
        Double nodeProbability = Probabilities.wordGivenTag(word2,current);
        return Prior * transitionProbability * nodeProbability;
    }

    void insertNode(Node node, Token.Tag tag, int column) {
        viterbiArray[column].put(tag,node);
    }

    void initialiseFirstColumn() {
        String firstWord = phrase[0];
        for (Token.Tag t: Token.Tag.values()) {
            Double probability = Probabilities.wordGivenTag(firstWord,t);
            viterbiArray[0].put(t,new Node(probability,null));
        }
    }

    Node makeNode(Token.Tag tag,int column) {
        String word = phrase[column];
        Node result = null;
        for (Token.Tag t:Token.Tag.values()) {
            double prior = getPrior(t,column-1);
            double probability = getProbability(tag,t,word,prior);
            if (result == null || result.Probability < probability) {
                result = new Node(probability,t);
            }
        }
        return result;
    }

    void fillColumn(int index) {
        for (Token.Tag tag: Token.Tag.values()) {
            insertNode(makeNode(tag,index),tag,index);
        }
    }

    void fillArray() {
        int phraseLength = viterbiArray.length;
        for (int i = 0;i < phraseLength;i++) {
            viterbiArray[i] = new EnumMap<>(Token.Tag.class);
        }
        initialiseFirstColumn();
        for (int i=1;i<phraseLength;i++) {
            fillColumn(i);
        }
    }

    Token.Tag getFinalTag() {
        Token.Tag result = null;
        double resultProbability = 0.0;
        EnumMap<Token.Tag,Node> finalColumn = viterbiArray[viterbiArray.length-1];
        for (Token.Tag t:Token.Tag.values()) {
            Node tagNode = finalColumn.get(t);
            if (result == null || tagNode.Probability > resultProbability) {
                result = t;
                resultProbability = tagNode.Probability;
            }
        }
        return result;
    }

    Token.Tag[] extractTags() {
        Token.Tag[] result = new Token.Tag[viterbiArray.length];
        Token.Tag finalTag = getFinalTag();
        System.out.println(finalTag.toString());
        result[result.length-1] = finalTag;
        Node node = viterbiArray[viterbiArray.length-1].get(finalTag);
        for (int i = result.length-2;i>=0;i--) {
            Token.Tag previousTag = node.Previous;
            result[i]= previousTag;
            node = viterbiArray[i].get(previousTag);
        }
        return result;
    }

}
