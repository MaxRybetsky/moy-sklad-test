package com.example.birdsapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "birds", schema = "public")
@Data
public class Bird {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "nest_id")
    private Nest nest;
}
