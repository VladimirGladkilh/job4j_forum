package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.UserRepository;

import javax.validation.ConstraintViolationException;

@Controller
public class RegControl {

    private final PasswordEncoder encoder;
    private final UserRepository users;

    public RegControl(PasswordEncoder encoder, UserRepository users) {
        this.encoder = encoder;
        this.users = users;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        try {
            users.save(user);
        } catch (ConstraintViolationException e) {
            return "redirect:/reg?error=true";
        }
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reg(@RequestParam(value = "error", required = false) String error, @ModelAttribute Post post, Model model) {
        String errorMessage = null;
        if (error != null) {
            errorMessage = "Duplicate user name !!!";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "reg";
    }
}