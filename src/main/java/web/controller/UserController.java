package web.controller;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String getUsersTable(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        userService.initUsers();
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") Long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam(value = "firstName") String firstname,
                          @RequestParam(value = "lastName") String lastName,
                          @RequestParam(value = "email") String email) {

        User user = new User(firstname, lastName, email);
        userService.addUser(user);

        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam(value = "id") Long id,
                             @RequestParam(value = "firstName") String firstname,
                             @RequestParam(value = "lastName") String lastName,
                             @RequestParam(value = "email") String email) {
        userService.updateUser(id, firstname, lastName, email);
        return "redirect:/users";
    }

}
