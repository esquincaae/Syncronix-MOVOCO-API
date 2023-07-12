package com.syncronix.movoco.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "watertemperaturesensor")
@Getter
@Setter
public class WaterTemperatureSensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column()
    private Float variance;

    @Column()
    private Float standardDeviation;

    @Column()
    private Float meanDeviation;
}
