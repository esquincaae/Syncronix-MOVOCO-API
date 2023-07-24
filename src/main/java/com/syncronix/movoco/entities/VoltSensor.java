package com.syncronix.movoco.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "voltage")
@Getter
@Setter
public class VoltSensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float volt;
    private Float media;
    private Float variance;
    private Float standardDeviation;
    private Float meanDeviation;

}

