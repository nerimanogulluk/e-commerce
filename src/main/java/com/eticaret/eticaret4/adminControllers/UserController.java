package com.eticaret.eticaret4.adminControllers;

import com.eticaret.eticaret4.adminEntities.User;
import com.eticaret.eticaret4.adminRepositories.RoleRepository;
import com.eticaret.eticaret4.adminRepositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class UserController {

    boolean updateStatus = false;
    final UserRepository uRepo;
    final RoleRepository rRepo;
    final BCryptPasswordEncoder encoder;

    public UserController(UserRepository uRepo, RoleRepository rRepo, BCryptPasswordEncoder encoder) {
        this.uRepo = uRepo;
        this.rRepo = rRepo;
        this.encoder = encoder;
    }

    @GetMapping("/user")
    public String user(Model model) {
        updateStatus = false;
        model.addAttribute("users", uRepo.findAll());
        model.addAttribute("roles", rRepo.findAll());
        model.addAttribute("updateStatus", updateStatus);
        return "admin/user";
    }

    @PostMapping("/userAdd")
    public String userAdd(User user) {
        user.setStatus(1);
        user.setPassword( encoder.encode(user.getPassword()) );
        uRepo.save(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/userDelete/{id}")
    public String userDelete(@PathVariable String id) {
        try {
            long usid = Long.parseLong(id);
            Optional<User> us = uRepo.findById(usid);
            if ( us.isPresent() ) {
                User usUpdate = us.get();
                usUpdate.setEnabled(false);
                uRepo.saveAndFlush(usUpdate);
            }

        } catch (Exception ex) {

        }
        return "redirect:/admin/user";
    }

    @GetMapping("/userUpdate/{id}")
    public String userUpdate(@PathVariable String id, Model model) {
        try {
            long usid = Long.parseLong(id);
            Optional<User> oUser = uRepo.findById(usid);
            if (oUser.isPresent()) {
                updateStatus = true;
                model.addAttribute("singleUser", oUser.get());
                model.addAttribute("updateStatus", updateStatus);
                model.addAttribute("roles", rRepo.findAll());
                model.addAttribute("users", uRepo.findAll());
            }
        } catch (Exception ex) {
        }
        return "admin/user";
    }

    @PostMapping("/userUpdateSave")
    public String userUpdateSave(User user) {
        user.setStatus(1);
        user.setPassword( encoder.encode(user.getPassword()) );
        uRepo.saveAndFlush(user);
        return "redirect:/admin/user";
    }

}
