import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RouteCalculatorTest extends TestCase {


    public RouteCalculator routeCalculator = Main.getRouteCalculator();
    public StationIndex stationIndex = routeCalculator.getStationIndex();

    @Test
    public void getShortestRoute1() {

        Station from = stationIndex.getStation("Приморская");
        Station to =stationIndex.getStation("Ладожская");

        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("Приморская"));
        expected.add(stationIndex.getStation("Василеостровская"));
        expected.add(stationIndex.getStation("Гостиный двор"));
        expected.add(stationIndex.getStation("Маяковская"));
        expected.add(stationIndex.getStation("Площадь Александра Невского",3));
        expected.add(stationIndex.getStation("Площадь Александра Невского",4));
        expected.add(stationIndex.getStation("Новочеркасская"));
        expected.add(stationIndex.getStation("Ладожская"));

        List<Station> actual = routeCalculator.getShortestRoute(from, to);

        assertEquals("С одной пересадкой",expected, actual);
    }

    @Test
    public void getShortestRoute0() {

        Station from = stationIndex.getStation("Озерки");
        Station to =stationIndex.getStation("Московская");
        List<Station> actual = routeCalculator.getShortestRoute(from, to);

        List<Station> expected = new ArrayList<>();
        int lineNum = stationIndex.getStation("Озерки").getLine().getNumber();
        Line line = stationIndex.getLine(lineNum);// Линия #2
        List<Station>stations=line.getStations();// Озерки #2, Московская #15
        for (int i=2;i<16;i++){
            expected.add(stations.get(i));
        }
        Assertions.assertEquals(expected, actual, "Без пересадок");
    }

    @Test
    public void getShortestRoute2() {

        Station from = stationIndex.getStation("Чкаловская");
        Station to =stationIndex.getStation("Ломоносовская");
        List<Station> actual = routeCalculator.getShortestRoute(from, to);

        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("Чкаловская",5));
        expected.add(stationIndex.getStation("Спортивная",5));
        expected.add(stationIndex.getStation("Адмиралтейская",5));
        expected.add(stationIndex.getStation("Садовая",5));
        expected.add(stationIndex.getStation("Сенная площадь",2));
        expected.add(stationIndex.getStation("Невский проспект",2));
        expected.add(stationIndex.getStation("Гостиный двор",3));
        expected.add(stationIndex.getStation("Маяковская",3));
        expected.add(stationIndex.getStation("Площадь Александра Невского",3));
        expected.add(stationIndex.getStation("Елизаровская",3));
        expected.add(stationIndex.getStation("Ломоносовская",3));



        Assertions.assertEquals(expected, actual,"С двумя пересадками");

    }

    @Test
    public void testCalculateDuration() throws Exception {
        setUp();
        Station from = stationIndex.getStation("Приморская");
        Station to =stationIndex.getStation("Ладожская");
        List<Station>route = routeCalculator.getShortestRoute(from, to);
        //  Построенный маршрут с одной пересадкой. Временные интервалы:
        //  Приморская                          ! 0
        //  Василеостровская                    ! 2.5
        //  Гостиный двор                       ! 2.5
        //  Маяковская                          ! 2.5
        //  Площадь Александра Невского         ! 2.5 Переход на другую линию
        //  Площадь Александра Невского         ! 3.5
        //  Новочеркасская                      ! 2.5
        //  Ладожская                           ! 2.5
        //                          ИТОГО       ! 18.5
        double expected = 18.5;
        double actual = RouteCalculator.calculateDuration(route);
        Assertions.assertEquals(expected, actual);
    }
}
