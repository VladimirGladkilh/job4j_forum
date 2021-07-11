
package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostMem implements Store {
    private final Map<Integer, Post> postMap = new ConcurrentHashMap<>();
    private final UserRepository userRepository;
    private final AtomicInteger post_id = new AtomicInteger();

    public PostMem(UserRepository userRepository) {
        this.userRepository = userRepository;
        User user = userRepository.findById(1);
        for (int i = 1; i < 5; i++) {
            Post post = Post.of("Subject " + i, user);
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
