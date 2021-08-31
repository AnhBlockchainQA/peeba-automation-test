package com.peeba.test.e2etests.processor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserData {

    @JsonProperty("id")
    Long id;

    @JsonProperty("user")
    User user;

    public static List<UserData> get(String fileName) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(fileName), new TypeReference<List<UserData>>() {
        });
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return user.userName;
    }

    public String getEmail() {
        return user.email;
    }

    public String getPassword() {
        return user.password;
    }

    static class User {
        @JsonProperty("userName")
        private String userName;

        @JsonProperty("email")
        private String email;

        @JsonProperty("password")
        private String password;
    }
}
