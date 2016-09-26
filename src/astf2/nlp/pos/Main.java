package astf2.nlp.pos;

import static astf2.nlp.pos.parseXML.tbc;
import static astf2.nlp.pos.parseXML.twc;

/**
 * Created by alistair on 18/09/2016.
 */
public class Main {

    public static void main(String[] args) {
        //Start by building the bigram counts
        parseXML parser = new parseXML();
        parser.parse();
        Viterbi viterbi = new Viterbi(args);
        Token.Tag[] tags = viterbi.extractTags();
        Token[] tokens = new Token[args.length];
        for (int i = 0;i<args.length;i++) {
            tokens[i] = new Token(args[i]);
            tokens[i].setTag(tags[i]);
            tokens[i].printToken();
        }
    }

}
