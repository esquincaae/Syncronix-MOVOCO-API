package com.syncronix.movoco.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "amp")
@Getter
@Setter
public class AmpSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float amp;
    private Float media;
    private Float variance;
    private Float standardDeviation;
    private Float meanDeviation;

}

