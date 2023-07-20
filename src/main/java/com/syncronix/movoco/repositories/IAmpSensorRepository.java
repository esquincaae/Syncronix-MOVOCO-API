package com.syncronix.movoco.repositories;

import com.syncronix.movoco.entities.AmpSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAmpSensorRepository extends JpaRepository<AmpSensor, Long> {

    @Query(value = "select amp.media from amp "+
            "order by media DESC LIMIT 1",nativeQuery = true)
    String findLastDataFromMedia();

    @Query(value = "select amp.mean_deviation from amp "+
            "order by mean_deviation DESC LIMIT 1",nativeQuery = true)
    String findLastDataFromMeanDeviation();

    @Query(value = "select amp.measure from amp "+
            "order by measure DESC LIMIT 1",nativeQuery = true)
    String findLastDataFromAmp();

    @Query(value = "select amp.standard_deviation from amp "+
            "order by standard_deviation DESC LIMIT 1",nativeQuery = true)
    String findLastDataFromStandardDeviation();

    @Query(value = "select amp.variance from amp "+
            "order by variance DESC LIMIT 1",nativeQuery = true)
    String findLastDataFromVariance();

}
