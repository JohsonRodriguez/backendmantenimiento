package backend.mantenimiento.repository;

import backend.mantenimiento.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users,Long> {
}
