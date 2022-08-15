package backend.mantenimiento.services;

import backend.mantenimiento.Dto.UserDto;
import backend.mantenimiento.entity.Users;
import backend.mantenimiento.exception.NotFoundException;
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

    @Override
    public UserDto loginUser(String username, String password) {
        var user = usersRepository.findByUsernameAndPassword(username,password);
        if (user == null) {
            throw new NotFoundException("Usuario o contraseña incorrectos" );
        }
        try {
            UserDto userDto= new UserDto();
            userDto.setName(user.getName());
            userDto.setRol(user.getRol());
            return userDto;
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }

    }
}
