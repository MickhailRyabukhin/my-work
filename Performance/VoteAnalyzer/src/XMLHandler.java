import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.sql.SQLException;

public class XMLHandler extends DefaultHandler {
    public static int records = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        String name;
        String birthDate;
        // находим имя и ДР избирателя и передаем в StringBuilder:
        try {
            if (qName.equals("voter")) {
                name = attributes.getValue("name");
                birthDate = attributes.getValue("birthDay");
                DBConnection.countVoter(name, birthDate);
                records++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        // Если записи кончились, выводим остаток записей в базу с помощью DBConnection.executeMultyinsert();
        if (qName.equals("voters") && records > DBConnection.getTotalRecords()) {
            try {
                DBConnection.executeMultyinsert();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
