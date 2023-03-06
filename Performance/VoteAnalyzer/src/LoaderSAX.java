import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class LoaderSAX {
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    private static HashMap<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();
    private static HashMap<Voter, Integer> voterCounts = new HashMap<>();

    public static void main(String[] args) throws Exception {
        String fileName = "res/data-18M.xml";

        long beforeMem = Runtime.getRuntime().freeMemory();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(new File(fileName), handler);
//        handler.printDuplicatedVoters();

        long afterMem = Runtime.getRuntime().freeMemory();
        long saxParseMem = afterMem - beforeMem;
        System.out.println(saxParseMem);
        //===========================================================================//
        // Затраты памяти : 18895376,11085624,17149024, 13216056, 11675936           //
        // В среднем ( с прогонкой файла) 14 404403 байт, почти вдвое меньше,        //
        // чем для DOM модели памяти.                                                //
        //===========================================================================//

//        parseFile(fileName);
//
//
//        //Printing results
//        System.out.println("Voting station work times: ");
//        for (Integer votingStation : voteStationWorkTimes.keySet()) {
//            WorkTime workTime = voteStationWorkTimes.get(votingStation);
//            System.out.println("\t" + votingStation + " - " + workTime);
//        }
//
//        System.out.println("Duplicated voters: ");
//        for (Voter voter : voterCounts.keySet()) {
//            Integer count = voterCounts.get(voter);
//            if (count > 1) {
//                System.out.println("\t" + voter + " - " + count);
//            }
//        }


    }

    private static void parseFile(String fileName) throws Exception {
        long beforeMem = Runtime.getRuntime().freeMemory();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(fileName));
        long afterMem = Runtime.getRuntime().freeMemory();
        long domParseMem = afterMem - beforeMem;
        //============================================================================//
        // Результат замера 9664736, 9664744, 9664744, 9664752, 9664744, 9664744      //
        // Среднее значение 9664744 = 9,6М для файла 1М                               //
        // 27035408, 26511136, 25986856, 27559712, 28084000, 26511120                 //
        // Среднее значение 26 948038 для файла 18М                                   //
        //============================================================================//
        System.out.println("\n domParseMem = " + domParseMem + "\n");

        findEqualVoters(doc);
        fixWorkTimes(doc);
    }

    private static void findEqualVoters(Document doc) throws Exception {
        NodeList voters = doc.getElementsByTagName("voter");
        int votersCount = voters.getLength();
        for (int i = 0; i < votersCount; i++) {
            Node node = voters.item(i);
            NamedNodeMap attributes = node.getAttributes();

            String name = attributes.getNamedItem("name").getNodeValue();
            Date birthDay = birthDayFormat.parse(attributes.getNamedItem("birthDay").getNodeValue());

            Voter voter = new Voter(name, birthDay);
            Integer count = voterCounts.get(voter);
            voterCounts.put(voter, count == null ? 1 : count + 1);
        }
    }

    private static void fixWorkTimes(Document doc) throws Exception {
        NodeList visits = doc.getElementsByTagName("visit");
        int visitCount = visits.getLength();
        for (int i = 0; i < visitCount; i++) {
            Node node = visits.item(i);
            NamedNodeMap attributes = node.getAttributes();

            Integer station = Integer.parseInt(attributes.getNamedItem("station").getNodeValue());
            Date time = visitDateFormat.parse(attributes.getNamedItem("time").getNodeValue());
            WorkTime workTime = voteStationWorkTimes.get(station);
            if (workTime == null) {
                workTime = new WorkTime();
                voteStationWorkTimes.put(station, workTime);
            }
            workTime.addVisitTime(time.getTime());
        }
    }
}