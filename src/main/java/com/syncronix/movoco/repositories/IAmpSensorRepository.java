package com.syncronix.movoco.repositories;

import com.syncronix.movoco.entities.AmpSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAmpSensorRepository extends JpaRepository<AmpSensor, Long> {

    @Query(value = "SELECT media FROM ampsensor ORDER BY media.id DESC ")
    String findLastDataFromMedia();
}
