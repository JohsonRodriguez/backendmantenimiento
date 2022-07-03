package backend.mantenimiento.repository;

import backend.mantenimiento.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location,Long> {
}
