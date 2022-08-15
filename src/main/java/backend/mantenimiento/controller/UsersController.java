package backend.mantenimiento.controller;


import backend.mantenimiento.Dto.Login;
import backend.mantenimiento.Dto.UserDto;
import backend.mantenimiento.entity.Users;
import backend.mantenimiento.services.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("/all")
    public Iterable<Users> getAllUsers(){
        return usersService.listUsers();
    }

    @PostMapping("/add")
    public void addUsers(@RequestBody Users users){
        usersService.newUsers(users);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody Login login){
      return  usersService.loginUser(login.getUsername(),login.getPassword());
    }

    @PutMapping("/update")
    public void updateUsers(@RequestBody Users users){
        usersService.updateUsers(users);
    }

    @GetMapping("/count")
    public Long countUsers(){
        return usersService.countUsers();
    }

    @GetMapping("findUsers/{name}")
    public Users getByUsers(@PathVariable("name") String name) {
        return usersService.searchUsers(name);
    }
}
