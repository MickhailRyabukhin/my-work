package java.core;

import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

class LineTest extends TestCase {
    private int number;
    private String name;
    private List<Station> stations;
    @Override
    protected void setUp() throws Exception {
        Line line1 = new Line(1,"Абинск-Тимашевская");
        Station station11 = new Station("Тимашевская",line1);
        Station station12 = new Station("Танцура-Крамаренко",line1);
        Station station13 = new Station("Дербентский",line1);
        Line line2 = new Line(2,"Novotitarovskaya - Staromyshastovskaya");
        Station station21=new Station("Novotitarovskaya",line2);
        Station station22 = new Station("BoykoPonura",line2);
        Station station23 = new Station("Staromyshastovckaya",line2);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @org.junit.jupiter.api.Test
    void tesGetNumber() {
       int expected = 1;
       int actual= new Line(1,"Абинск-Тимашевская").getNumber();
       assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void testGetName() {
        String expected = "Novotitarovskaya - Staromyshastovskaya";
        String actual = new Line(2,
                "Novotitarovskaya - Staromyshastovskaya").getName();
        assertEquals(expected,actual);
    }

    @org.junit.jupiter.api.Test
    void addStation() {
        Line line1 = new Line(1,"Абинск-Тимашевская");
        Station station11 = new Station("Тимашевская",line1);
        List<Station> expected = new ArrayList<Station>();
        expected.add(station11);
        line1.addStation(station11);
        assertEquals(expected,line1.getStations());

    }

    @org.junit.jupiter.api.Test
    void getStations() {
        Line line1 = new Line(1,"Абинск-Тимашевская");
        line1.addStation(new Station("Тимашевская",line1));
        line1.addStation(new Station("Дербентский",line1));
        line1.addStation(new Station("Медведовская",line1));
        List<Station> expected = new ArrayList<Station>();
        expected.add(new Station("Тимашевская",line1));
        expected.add(new Station("Дербентский",line1));
        expected.add(new Station("Медведовская",line1));
        assertEquals(expected,line1.getStations());
    }

    @org.junit.jupiter.api.Test
    void compareTo() {
       int expected = 1;
       Line line1 = new Line(1,"Абинск-Тимашевская");
       assertEquals(expected,line1.getNumber());
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        Line line1 = new Line(1,"Абинск-Тимашевская");
        Line line2 = new Line(2,"Novotitarovskaya - Staromyshastovskaya");
        Line line3 = new Line(1,"АХЗ");

        assertEquals ("Сравнение разных линий ",false,line1.equals(line2));
        assertEquals ("Сравнение одинаковых линий",true,line1.equals(line3));

    }
}