#Part of Speech Tagging with Java

A rudimentary implementation of stochastic POS tagging using bigram probabilities obtained from the BNC-Baby Corpus. The CLAWS5 tagset is used.


##Overview
Stochastic POS taggers take an arbitrary string of text and assign a tag to each word (in simple instances, 'adjective' or 'noun', this implementation uses the CLAWS5 tagset listed [here](http://ucrel.lancs.ac.uk/claws5tags.html).)

The tagger aims to assign the most likely tag sequence given the whole phrase. In other words, it attempts to calculate:

![equation](http://bit.ly/2du6Fif)

This cannot be calculated directly from the corpus, so it is transformed via Bayes' Theorem into an equation that can:

![equation](http://bit.ly/2deo1SN)

The denominator is constant across all potential tag sequences, so the algorithm only attempts to maximise the numerator.

For a given tag sequence, both terms can be estimated from an annotated corpus. This implementation uses the [BNC Baby Corpus](http://www.natcorp.ox.ac.uk/corpus/babyinfo.html), a small subset of the full British National Corpus.

The first term is estimated as follows:

![equation](http://bit.ly/2des7Kq)

i.e. the words are assumed to be independent of each other. The individual probabilities are estimated from the corpus as follows:

![equation](http://bit.ly/2dulWzR)

C<sub>w,t</sub> is the number of instances of word w tagged with tag t in the annotated corpus, and C<sub>t</sub> is the total number of words tagged with tag t.
Currently, no smoothing is done so 0 probabilities are possible. In the future, I will use +1 smoothing here.

Usage instructions to come.


