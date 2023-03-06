package core;

public class Station implements Comparable<Station> {
    private Line line;
    private String name;

    public Station(String name, Line line) {
        this.name = name;
        this.line = line;
    }

    public Line getLine() {
        return line;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Station station)throws NullPointerException {
        int result;

        int lineComparison = line.compareTo(station.getLine());
        if (lineComparison != 0) {
            result = lineComparison;
        } else {
            result = name.compareToIgnoreCase(station.getName());
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return compareTo((Station) obj) == 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
