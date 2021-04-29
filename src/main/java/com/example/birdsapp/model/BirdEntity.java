package com.example.birdsapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "birds", schema = "public")
@Data
public class BirdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "fly")
    private boolean fly;

    @OneToOne
    @JoinColumn(name = "nest_id")
    private NestEntity nest;
}
