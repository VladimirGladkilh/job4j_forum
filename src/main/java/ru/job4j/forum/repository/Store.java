package ru.job4j.forum.repository;

import ru.job4j.forum.model.Post;

import java.util.Collection;

public interface Store {
    Collection<Post> findAll();

    void save(Post post);

    Post findById(int id);

    void delete(Post post);
}
