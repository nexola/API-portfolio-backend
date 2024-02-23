package com.nexola.apiportfolio.models.dto;

import com.nexola.apiportfolio.models.entities.Role;
import com.nexola.apiportfolio.models.entities.User;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {
    private String id;
    private String name;
    private String email;

    private Set<RoleDTO> roles = new HashSet<>();

    public UserDTO(){}

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        for (Role role : entity.getRoles()) {
            roles.add(new RoleDTO(role));
        }
    }

    public UserDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }
}
