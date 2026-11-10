import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public interface Parse {
    public void parse(String path) throws SAXException, ParserConfigurationException;
}
