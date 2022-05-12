package com.learning.airport.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "passengers")
@Data
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;
}
