package backend.mantenimiento.services;

import backend.mantenimiento.entity.Users;
import backend.mantenimiento.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Iterable<Users> listUsers() {
        return usersRepository.findAll();
    }

    @Override
    public void newUsers(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void updateUsers(Users users) {
        usersRepository.save(users);
    }

    @Override
    public Long countUsers() {
        return usersRepository.count();
    }

    @Override
    public Users searchUsers(String name) {
        return usersRepository.searchUsersByName(name);
    }
}
