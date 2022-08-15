package backend.mantenimiento.services;


import backend.mantenimiento.Dto.UserDto;
import backend.mantenimiento.entity.Users;

public interface UsersService {
    Iterable<Users> listUsers();
    void newUsers(Users users);
    void updateUsers(Users users);
    Long countUsers();
    Users searchUsers(String name);
    UserDto loginUser(String username, String password);
}
