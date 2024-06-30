package CRUD.Controllers;


import CRUD.model.User;
import CRUD.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;



@Controller
@RequestMapping
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }


    @GetMapping("user/new")
    public String NewUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/save")
    public String CreateUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "new";
        }
        userService.addUser(user);
        return "redirect:/user";
    }

    @GetMapping("/user/edit")
    public String edit(@RequestParam("id")int id,Model model){
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        }
        userService.updateUser(user);
        return "redirect:/user";
    }

    @PostMapping("/user/delete")
    public String deleteUser(@RequestParam(name = "id") int id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
