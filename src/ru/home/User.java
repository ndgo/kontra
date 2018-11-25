package ru.home;

import java.util.Date;

public class User {
    private final int id;
    private final String name;
    private final String telephone;
    private final Date birthDay;

    public User(int id, String name, String telephone, Date birthDay) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.birthDay = birthDay;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public String getTelephone() {
        return telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "ID:" + id + ", " +
                "ИМЯ: " + name + ", " +
                "ТЕЛЕФОН:" + telephone + ", " +
                "ДАТА:" + DateUtil.toString(birthDay);
    }
}
