package com.Dou888311.ArtPlanTest.Entity;

import com.Dou888311.ArtPlanTest.DTO.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    private String id;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String name;
    private String kind;
    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

}
