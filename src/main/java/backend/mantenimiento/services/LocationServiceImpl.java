package backend.mantenimiento.services;

import backend.mantenimiento.entity.Location;
import backend.mantenimiento.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService{
    private  LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    @Override
    public Iterable<Location> listLocation() {
        return locationRepository.findAll();
    }

    @Override
    public void newLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public void updateLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public Long countLocation() {
        return  locationRepository.count();
    }

    @Override
    public Location searchLocation(String name) {
        return locationRepository.searchByName(name);
    }
}
