package astf2.nlp.pos;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
//import java.io.IOException;

/**
 * Created by alistair on 20/09/2016.
 */
public class parseXML extends DefaultHandler {

    Token.Tag previousTag;
    Token.Tag currentTag;
    boolean process = false;

    static TagWordCounts twc = TagWordCounts.getTagWordCounts();
    static TagBigramCounts tbc = TagBigramCounts.getTagBigramCounts();

    @Override
    public void startDocument() throws SAXException {
        previousTag = null;
        currentTag = null;
    }

    @Override
    public void startElement(String namespaceURI,
                             String localName,
                             String qName,
                             Attributes atts)
            throws SAXException {

        if (qName == "w") {
            String tag = atts.getValue("c5");
            if (tag.contains("-")) {
                tag = (tag.split("-"))[0]; //If tagging is ambiguous, just take first tag
            }
            previousTag = currentTag;
            currentTag = Token.Tag.valueOf(tag);
            process = true;
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) {
        if (process) {
            String word = new String(chars,start,length);
            twc.countWord(currentTag,word);
            if (previousTag != null) {
                tbc.addFollow(previousTag,currentTag);
            }
            process = false;
        }
    }

    public void parse() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(false);
        try {
            SAXParser saxParser = factory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(new parseXML());
            File acaDirectory = new File("/Users/alistair/Documents/Coding/BNC-Baby/2553/2553/download/Texts/aca/");
            //String prefix = "/Users/alistair/Documents/Coding/BNC-Baby/2553/2553/download/Texts/aca/";
            File[] acaTexts = acaDirectory.listFiles();
            for (File f:acaTexts) {
                if (!f.getName().startsWith(".")) {
                    xmlReader.parse(f.getAbsolutePath());
                }
            }
            //xmlReader.parse(prefix+ "ECV.xml");    // specify handler
        }
        catch (ParserConfigurationException e1) {
            System.out.println("exception1");
        }
        catch (SAXException e1) {
            System.out.println("exception2");
        }
        catch (IOException e) {
            System.out.println("exception3");
        }
    }

}
