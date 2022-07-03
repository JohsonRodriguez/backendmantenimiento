package backend.mantenimiento.controller;


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
