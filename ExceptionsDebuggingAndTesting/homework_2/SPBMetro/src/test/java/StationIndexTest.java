import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.*;

class StationIndexTest extends TestCase {

    public Map<Integer, Line> number2line = new HashMap<>();
    public TreeSet<Station> stations=new TreeSet<>();
    public Map<Station, TreeSet<Station>> connections=new TreeMap<>();
    Line line1 = new Line(1, "Абинск-Тимашевская");
    Station station11 = new Station("Тимашевская", line1);
    Station station12 = new Station("Танцура-Крамаренко", line1);
    Station station13 = new Station("Дербентский", line1);
    Line line2 = new Line(2, "Новотитаровская - Старомышастовская");
    Station station21 = new Station("Новотитаровская", line2);
    Station station22 = new Station("БойкоПонура", line2);
    Station station23 = new Station("Старомышастовская", line2);
    public StationIndex stationIndex = new StationIndex();
    @Test
    void testAddStation() {
        TreeSet<Station> expected = new TreeSet<>();
        expected.add(station11);
        stationIndex.addStation(station11);
        TreeSet actual =stationIndex.getStations();
        assertEquals(expected,actual);
    }

    @Test
    void addLine() {
        Map<Integer, Line> expected = new HashMap<>();
        expected.put(1,line1);
        stationIndex.addLine(line1);
        Map<Integer, Line> actual = stationIndex.getNumber2line();
        assertEquals(expected,actual);

    }

    @Test
    void testAddConnection() {
        List<Station> stationList = new ArrayList<Station>();
        stationList.add(station13);
        stationList.add(station22);
        TreeSet<Station> temp =new TreeSet<>();
        TreeSet<Station> temp1 =new TreeSet<>();
        Map<Station, TreeSet<Station>> expected = new TreeMap<>();
        temp.add(station22);
        expected.put(station13,temp);
        temp1.add(station13);
        expected.put(station22,temp1);
        stationIndex.addConnection(stationList);
        Map<Station, TreeSet<Station>> actual = stationIndex.getConnections();
        assertEquals(expected,actual);

    }

    @Test
    void testGetLine() {
        Line line3=new Line(3,"AXZ");
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        Line expected = line2;
        Line actual = stationIndex.getLine(2);
        assertEquals(expected,actual);
    }

    @Test
    void testgetStation() {
        stationIndex.addStation(station11);
        stationIndex.addStation(station12);
        stationIndex.addStation(station13);
        Station expected = station12;
        Station actual = stationIndex.getStation("Танцура-Крамаренко");
        assertEquals("Станция существует",expected,actual);
        expected =null;
        actual = stationIndex.getStation("Васильковая");
        assertEquals("Такой станции нет",expected,actual);

    }

    @Test
    void testGetStation() {
        stationIndex.addLine(line1);
        stationIndex.addStation(station11);
        stationIndex.addStation(station12);
        stationIndex.addStation(station13);
        for (Station s:stationIndex.getStations()) {
            line1.addStation(s);
        }
        Station expected = station12;
        Station actual = stationIndex.getStation("Танцура-Крамаренко",1);
        assertEquals("Станция существует",expected,actual);
        expected=null;
        actual=stationIndex.getStation("Танцура-Крамаренко",2);
        assertEquals("Линия не существует",expected,actual);
        expected = null;
        actual = stationIndex.getStation("Вишневая",1);
        assertEquals("Станция не существует",expected,actual);
    }

    @Test
    void getConnectedStations() {
        List<Station> stationList = new ArrayList<Station>();
        stationList.add(station13);
        stationList.add(station22);
        stationIndex.addConnection(stationList);
        TreeSet<Station> expected = new TreeSet<>();
        expected.add(station13);
        TreeSet<Station>actual = (TreeSet<Station>) stationIndex.getConnectedStations(station22);
        assertEquals(expected,actual);
    }
}
