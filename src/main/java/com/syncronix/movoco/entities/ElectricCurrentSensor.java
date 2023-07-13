package com.syncronix.movoco.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "amp")
@Getter
@Setter
public class ElectricCurrentSensor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float amp;
    private Float media;
    private Float mediana;
    private Float moda;
    private Float variance;
    private Float standardDeviation;
    private Float meanDeviation;

    @ManyToOne
    @JoinColumn(name = "amp_Id")
    private User user;
}
