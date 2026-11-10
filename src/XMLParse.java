import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class XMLParse implements  Parse{
    public void parse(String path) throws SAXException, ParserConfigurationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
     try {
            parser.parse(new File(path), handler);
        }catch (Exception e) {
            System.out.print("Проблема с файлом! \n");
        }
    }
}
