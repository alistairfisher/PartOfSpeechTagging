package astf2.nlp.pos;

/**
 * Created by alistair on 23/09/2016.
 */
public class Node {

    final double Probability;
    final Token.Tag Previous;

    Node(double probability, Token.Tag previous) {
        this.Probability = probability;
        this.Previous = previous;
    }

}
