package org.example.cada.role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.cada.config.BaseEntity;

@Getter
@Setter
@Entity(name = "role")
public class Role extends BaseEntity {

    @Column(name = "name")
    String name;
}
