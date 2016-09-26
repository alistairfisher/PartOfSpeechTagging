package astf2.nlp.pos;

/**
 * Created by alistair on 18/09/2016.
 */
public class Token {

    public String word;

    public Tag tag;

    public void setTag(Tag t) {
        tag = t;
    }

    public Token(String word) {
        this.word = word;
    }

    public void printToken() {
        System.out.printf("%s : %s ",word,tag.toString());
    }

    public enum Tag {
        AJ0, //adjective (unmarked) (e.g. GOOD, OLD)
        AJC, //comparative adjective (e.g. BETTER, OLDER)
        AJS, //superlative adjective (e.g. BEST, OLDEST)
        AT0, //article (e.g. THE, A, AN)
        AV0, //adverb (unmarked) (e.g. OFTEN, WELL, LONGER, FURTHEST)
        AVP, //adverb particle (e.g. UP, OFF, OUT)
        AVQ, //wh-adverb (e.g. WHEN, HOW, WHY)
        CJC, //coordinating conjunction (e.g. AND, OR)
        CJS, //subordinating conjunction (e.g. ALTHOUGH, WHEN)
        CJT, //the conjunction THAT
        CRD, //cardinal numeral (e.g. 3, FIFTY-FIVE, 6609) (excl ONE)
        DPS, //possessive determiner form (e.g. YOUR, THEIR)
        DT0, //general determiner (e.g. THESE, SOME)
        DTQ, //wh-determiner (e.g. WHOSE, WHICH)
        EX0, //existential THERE
        ITJ, //interjection or other isolate (e.g. OH, YES, MHM)
        NN0, //noun (neutral for number) (e.g. AIRCRAFT, DATA)
        NN1, //singular noun (e.g. PENCIL, GOOSE)
        NN2, //plural noun (e.g. PENCILS, GEESE)
        NP0, //proper noun (e.g. LONDON, MICHAEL, MARS)
        NULL, //the null tag (for items not to be tagged)
        ORD, //ordinal (e.g. SIXTH, 77TH, LAST)
        PNI, //indefinite pronoun (e.g. NONE, EVERYTHING)
        PNP, //personal pronoun (e.g. YOU, THEM, OURS)
        PNQ, //wh-pronoun (e.g. WHO, WHOEVER)
        PNX, //reflexive pronoun (e.g. ITSELF, OURSELVES)
        POS, //the possessive (or genitive morpheme) 'S or '
        PRF, //the preposition OF
        PRP, //preposition (except for OF) (e.g. FOR, ABOVE, TO)
        PUL, //punctuation - left bracket (i.e. ( or [ )
        PUN, //punctuation - general mark (i.e. . ! , : ; - ? ... )
        PUQ, //punctuation - quotation mark (i.e. ` ' " )
        PUR, //punctuation - right bracket (i.e. ) or ] )
        TO0, //infinitive marker TO
        UNC, //"unclassified" items which are not words of the English lexicon
        VBB, //the "base forms" of the verb "BE" (except the infinitive), i.e. AM, ARE
        VBD, //past form of the verb "BE", i.e. WAS, WERE
        VBG, //-ing form of the verb "BE", i.e. BEING
        VBI, //infinitive of the verb "BE"
        VBN, //past participle of the verb "BE", i.e. BEEN
        VBZ, //-s form of the verb "BE", i.e. IS, 'S
        VDB, //base form of the verb "DO" (except the infinitive), i.e.
        VDD, //past form of the verb "DO", i.e. DID
        VDG, //-ing form of the verb "DO", i.e. DOING
        VDI, //infinitive of the verb "DO"
        VDN, //past participle of the verb "DO", i.e. DONE
        VDZ, //-s form of the verb "DO", i.e. DOES
        VHB, //base form of the verb "HAVE" (except the infinitive), i.e. HAVE
        VHD,//past tense form of the verb "HAVE", i.e. HAD, 'D
        VHG, //-ing form of the verb "HAVE", i.e. HAVING
        VHI, //infinitive of the verb "HAVE"
        VHN, //past participle of the verb "HAVE", i.e. HAD
        VHZ, //-s form of the verb "HAVE", i.e. HAS, 'S
        VM0, //modal auxiliary verb (e.g. CAN, COULD, WILL, 'LL)
        VVB, //base form of lexical verb (except the infinitive)(e.g. TAKE, LIVE)
        VVD, //past tense form of lexical verb (e.g. TOOK, LIVED)
        VVG, //-ing form of lexical verb (e.g. TAKING, LIVING)
        VVI, //infinitive of lexical verb
        VVN, //past participle form of lex. verb (e.g. TAKEN, LIVED)
        VVZ, //-s form of lexical verb (e.g. TAKES, LIVES)
        XX0, //the negative NOT or N'T
        ZZ0, //alphabetical symbol (e.g. A, B, c, d)
    }

}
