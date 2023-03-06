import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport krasnodar = Airport.getInstance();
        List<Flight> flightsDep2Hours =
                findPlanesLeavingInTheNextTwoHours(krasnodar);
        for (Flight flight2Dep : flightsDep2Hours) {
            System.out.println(flight2Dep);
        }
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        List<Terminal> terminals = airport.getTerminals();
        List<Flight> flights;

        Date now = new Date();
        long twoHoursToMilliseconds = 2 * 60 * 60 * 1000;


        return flights= terminals.stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType() == Flight.Type.DEPARTURE)
                .filter((f) -> f.getDate().after(now))
                .filter((f) -> f.getDate().getTime()
                        < (now.getTime() + twoHoursToMilliseconds))
                .collect(Collectors.toList());
    }
}