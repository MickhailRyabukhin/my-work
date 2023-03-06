package java.core;

import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationTest extends TestCase {
    public Line line1 = new Line(1,"Абинск-Тимашевская");
    public Station station11 = new Station("Тимашевская",line1);
    public Station station12 = new Station("Танцура-Крамаренко",line1);
    public Station station13 = new Station("Дербентский",line1);

    @Test
    void getLine() {
        line1.addStation(station11);
        line1.addStation(station12);
        line1.addStation(station13);
        Line expected = line1;
        Line actual = station13.getLine();
        assertEquals(expected,actual);
    }

    @Test
    void testGetName() {
        String expected = "Тимашевская";
        String actual = station11.getName();
        assertEquals(expected,actual);
    }

    @Test
    void compareTo() {
        int expected = station11.getName().compareTo(station13.getName());
        int actual = station11.compareTo(station13);
        assertEquals(expected,actual);
    }

    @Test
    void testEquals() {
        boolean expected = false;
        boolean actual = station11.equals(station13);
        assertEquals(expected,actual);
    }

    @Test
    void testToString() {
        String expected = station12.getName();
        String actual = station12.toString();
        assertEquals(expected,actual);
    }
}