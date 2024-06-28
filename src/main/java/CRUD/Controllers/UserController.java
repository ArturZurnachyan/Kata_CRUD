package CRUD.Controllers;

import CRUD.dao.UserDao;
import CRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class UserController {


    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/user")
    public String getUsers(Model model) {
        model.addAttribute("users", userDao.getUsers());
        return "users";
    }


    @GetMapping("user/new")
    public String NewUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/save")
    public String CreateUser(@ModelAttribute("user") User user) {
        userDao.saveUser(user);
        return "redirect:/user";
    }

    @GetMapping("/user/edit")
    public String edit(@RequestParam("id")int id,Model model){
        model.addAttribute("user",userDao.getUser(id));
        return "edit";
    }

    @PostMapping("/user/getUser")
    public String UpdateUser(@RequestParam(name = "id") int id, @ModelAttribute("user") User user) {
        userDao.updateUser(id, user);
        return "redirect:/user";
    }

    @PostMapping("/user/delete")
    public String DeleteUser(@RequestParam(name = "id") int id) {
        userDao.deleteUser(id);
        return "redirect:/user";
    }
}
