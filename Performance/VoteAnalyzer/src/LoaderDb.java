import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class LoaderDb {

    public static void main(String[] args) throws Exception {

        String fileName = "res/data-1572M.xml";

        long start = System.currentTimeMillis();
        DBConnection.getConnection();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(new File(fileName), handler);
        System.out.println("\nПарсинг занял " + (System.currentTimeMillis() - start) + " ms \n" +
                "Прочитано " + DBConnection.getTotalRecords() + " записей");
        System.out.println("Всего в файле " + XMLHandler.records + " записей");

    }
}



