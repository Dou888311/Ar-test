package com.Dou888311.ArtPlanTest.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String username;
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    private String password;
    @OneToMany(mappedBy="user")
    private List<Animal> animals = new ArrayList<>();
}
