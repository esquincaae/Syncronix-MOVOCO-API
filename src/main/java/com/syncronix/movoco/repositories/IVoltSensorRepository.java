package com.syncronix.movoco.repositories;

import com.syncronix.movoco.entities.VoltSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IVoltSensorRepository extends JpaRepository<VoltSensor, Long> {

    @Query(value = "select voltage.media from voltage "+
            "order by media DESC LIMIT 1",nativeQuery = true)
    String findLastDataFromMedia();

    @Query(value = "select voltage.mean_deviation from voltage "+
            "order by mean_deviation DESC LIMIT 1",nativeQuery = true)
    String findLastDataFromMeanDeviation();

    @Query(value = "select voltage.measure from voltage "+
            "order by measure DESC LIMIT 1",nativeQuery = true)
    String findLastDataFromVolt();

    @Query(value = "select voltage.standard_deviation from voltage "+
            "order by standard_deviation DESC LIMIT 1",nativeQuery = true)
    String findLastDataFromStandardDeviation();

    @Query(value = "select voltage.variance from voltage "+
            "order by variance DESC LIMIT 1",nativeQuery = true)
    String findLastDataFromVariance();
}
