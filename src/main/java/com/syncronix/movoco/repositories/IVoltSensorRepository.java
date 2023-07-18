package com.syncronix.movoco.repositories;

import com.syncronix.movoco.entities.VoltSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IVoltSensorRepository extends JpaRepository<VoltSensor, Long> {


}
