package ru.home;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class UserManager {

    private final AtomicInteger idGenerator = new AtomicInteger();
    private final List<User> users = new ArrayList<>();

    public UserManager() {

        Date current = new Date();

        save("Whistler", "8-800-555-353-35", DateUtil.rollDays(current, -1));
        save("Jackson Hole", "129-24-30", DateUtil.rollDays(current, -2));
        save("Snowbird", "8-916-42-36-771", DateUtil.rollDays(current, -3));
        save("Telluride", "8-910-584-16-36", DateUtil.rollDays(current, -4));
        save("Taos", "8-910-421-04-50", DateUtil.rollDays(current, -5));
        save("Snowbird", "8-800-555-353-35", DateUtil.rollDays(current, -6));
    }


    public User save(String name, String telephone, Date birthDay) {
        User user = new User(idGenerator.getAndIncrement(), name, telephone, birthDay);
        users.add(user);
        return user;
    }


    public List<User> getAll() {
        return users;
    }


    public List<User> searchByName(String name) {
        List<User> result = new ArrayList<>();

        for (User user : users) {
            if (user.getName().equals(name)) {
                result.add(user);
            }
        }

        return result;
    }


    public List<User> searchByTelephone(String telephone) {
        List<User> result = new ArrayList<>();

        for (User user : users) {
            if (user.getName().equals(telephone)) {
                result.add(user);
            }
        }

        return result;
    }


    public List<User> searchByDate(Date moment) {
        List<User> result = new ArrayList<>();

        for (User user : users) {
            if (Objects.equals(user.getBirthDay(), moment)) {
                result.add(user);
            }
        }

        return result;
    }


    public void delete(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return;
            }
        }
    }
}
