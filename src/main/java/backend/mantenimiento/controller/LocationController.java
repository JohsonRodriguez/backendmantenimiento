package backend.mantenimiento.controller;


import backend.mantenimiento.entity.Location;
import backend.mantenimiento.services.LocationService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/location")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/all")
    public Iterable<Location> getAllLocations(){
        return locationService.listLocation();
    }

    @PostMapping("/add")
    public void addLocation(@RequestBody Location location){
        locationService.newLocation(location);
    }

    @PutMapping("/update")
    public void updateLocation(@RequestBody Location location){locationService.updateLocation(location);
    }

    @GetMapping("/count")
    public Long countLocation(){
        return locationService.countLocation();
    }

    @GetMapping("findLocation/{name}")
    public Location getByLocation(@PathVariable("name") String name) {
        return locationService.searchLocation(name);
    }
}
