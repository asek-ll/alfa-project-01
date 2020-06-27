package ru.alfabattle.contest.project.utils;

public class Coords {
    private static final double R = 6_371_000.0;

    private final double lat;
    private final double lon;

    public Coords(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double distanceToInMeters(Coords other) {
        double lat1 = Math.toRadians(lat);
        double lon1 = Math.toRadians(lon);
        double lat2 = Math.toRadians(other.lat);
        double lon2 = Math.toRadians(other.lon);
        return 2 * R * Math.asin(
                Math.sqrt(
                        Math.pow(Math.sin((lat2 - lat1)/2), 2)
                        + Math.cos(lat1) * Math.cos(lat2)
                        * Math.pow(Math.sin((lon2-lon1)/2), 2)
                )
        );
    }
}
