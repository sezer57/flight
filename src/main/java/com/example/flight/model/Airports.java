package com.example.flight.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@Table(name = "Airports")
public class Airports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    public Airports(){}

    public Airports(String location) {
        this.location = location;
    }
}
