package kr.mjc.sehyuckpark.web.dao;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String email;
    private String name;
    private String password;

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", email='" + email + '\'' +
                ", name='" + name + '\'' + '}';
    }
}