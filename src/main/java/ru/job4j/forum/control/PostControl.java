package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostControl {
    private final PostRepository postRepository;

    @Autowired
    public PostControl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @GetMapping("/create")
    public String create(Model model) {
        return "post/create";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") long id, Model model) {
        model.addAttribute("post", postRepository.findById(id).orElse(null));
        return "post/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post, HttpServletRequest req) {
        postRepository.save(post);
        return "redirect:/";
    }

}