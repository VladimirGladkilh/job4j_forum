package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/*
времменная реализация. в дальнейшем переедет на Spring Data CRUD etc
 */
@Repository
public class UserRepository {
    private final Map<Integer, User> userMap = new ConcurrentHashMap<>();
    private final AtomicInteger user_id = new AtomicInteger();

    public UserRepository() {
        userMap.put(1, User.of("user1", "123"));
        userMap.put(2, User.of("user2", "123"));
        userMap.put(3, User.of("user3", "123"));
    }

    public Collection<User> findAll() {
        return userMap.values();
    }

    public void save(User user) {
        if (user.getId() == 0) {
            user.setId(user_id.incrementAndGet());
        }
        userMap.put(user.getId(), user);
    }

    public User findById(int id) {
        return userMap.get(id);
    }

    public User findByName(String name) {
        return userMap.values().stream().filter(user -> name.equalsIgnoreCase(user.getUsername())).findAny().orElse(null);
    }

    public void delete(User user) {
        userMap.remove(user.getId());
    }
}
