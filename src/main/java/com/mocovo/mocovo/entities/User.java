package com.mocovo.mocovo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @ManyToOne
    @JoinColumn (name = "role_id", referencedColumnName = "id")
    @JsonBackReference
    private Rol role;
}