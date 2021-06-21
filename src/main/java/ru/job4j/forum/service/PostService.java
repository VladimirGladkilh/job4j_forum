package ru.job4j.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.Store;

import java.util.Collection;

@Service
public class PostService {
    private final Store postRepository;

    @Autowired
    public PostService(Store postRepository) {
        this.postRepository = postRepository;
    }

    public Collection<Post> getAll() {
        return postRepository.findAll();
    }
}
