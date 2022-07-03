package backend.mantenimiento.services;


import backend.mantenimiento.entity.Location;

public interface LocationService {
    Iterable<Location> listLocation();
    void newLocation(Location location);
    void updateLocation(Location location);
    Long countLocation();
    Location searchLocation(String name);
}
