package backend.mantenimiento.repository;

import backend.mantenimiento.Dto.UserDto;
import backend.mantenimiento.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users,Long> {
    Users searchUsersByName(String name);
    Users findByUsernameAndPassword(String username, String password);
}
