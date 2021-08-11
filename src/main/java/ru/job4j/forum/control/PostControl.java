package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.Store;
import ru.job4j.forum.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostControl {
    private final Store postMem;
    private final UserService userService;

    @Autowired
    public PostControl(Store accidents, UserService userService) {
        this.postMem = accidents;
        this.userService = userService;
    }


    @GetMapping("/create")
    public String create(Model model) {
        return "post/create";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        Post post = postMem.findById(id);
        model.addAttribute("post", post);
        User user = post.getUser();
        model.addAttribute("username", user.getUsername());
        return "post/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post, HttpServletRequest req, Model model) {
        String username = req.getParameter("username");
        if (username != null) {
            User user = userService.findByName(username);
            post.setUser(user);
        }
        postMem.save(post);
        return "redirect:/";
    }

}