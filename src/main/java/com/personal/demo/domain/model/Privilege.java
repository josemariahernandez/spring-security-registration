package com.personal.demo.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Chema on 18/05/2017.
 */
@Data
@Entity
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

}
