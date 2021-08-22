package com.mellow.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@ConfigurationProperties(value = "user")
public class User implements Serializable {
    private String username;
    private String password;
    private List<String> nickname;
    private List<Mobel> mobels;

    public List<String> getNickname() {
        return nickname;
    }

    public void setNickname(List<String> nickname) {
        this.nickname = nickname;
    }

    public List<Mobel> getMobels() {
        return mobels;
    }

    public void setMobels(List<Mobel> mobels) {
        this.mobels = mobels;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname=" + nickname +
                ", mobels=" + mobels +
                '}';
    }
}
