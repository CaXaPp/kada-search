package org.example.cada.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import org.example.cada.config.BaseEntity;
import org.example.cada.role.Role;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();
}
