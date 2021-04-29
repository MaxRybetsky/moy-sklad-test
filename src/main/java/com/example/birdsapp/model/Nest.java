package com.example.birdsapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nest", schema = "public")
@Data
public class Nest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "nest_id")
    private List<Bird> birds;
}

