package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostMem implements Store {
    private final Map<Integer, Post> postMap = new ConcurrentHashMap<>();
    private final AtomicInteger post_id = new AtomicInteger();

    public PostMem() {
        for (int i = 1; i < 5; i++) {
            Post post = Post.of("Subject " + i);
            save(post);
        }
    }

    @Override
    public Collection<Post> findAll() {
        return postMap.values();
    }

    @Override
    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(post_id.incrementAndGet());
        }
        postMap.put(post.getId(), post);
    }

    @Override
    public Post findById(int id) {
        return postMap.get(id);
    }

    @Override
    public void delete(Post post) {
        postMap.remove(post.getId());
    }


}
