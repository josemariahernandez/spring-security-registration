package com.personal.demo.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Chema on 18/05/2017.
 */
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    @Column(length = 60)
    private String password;

    @Column(name = "enabled")
    private boolean enabled;
    private String secret;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User(){
        super();
        this.enabled = false;
    }
}
