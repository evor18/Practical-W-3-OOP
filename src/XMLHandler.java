import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {
    public void startElement( String uri, String localName, String qName, Attributes attributes)  {
        if (qName.equals("item")) {
            String cityName = attributes.getValue("city");
            String streetName = attributes.getValue("street");
            String houseName = attributes.getValue("house");
            String countFloor = attributes.getValue("floor");
            AddressDefining defining = new AddressDefining();
            defining.add_address( Main.cities, cityName, streetName, houseName, countFloor);
        }
    }
}