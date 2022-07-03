package backend.mantenimiento.services;


import backend.mantenimiento.entity.Users;

public interface UsersService {
    Iterable<Users> listUsers();
    void newUsers(Users users);
    void updateUsers(Users users);
    Long countUsers();
    Users searchUsers(String name);
}
