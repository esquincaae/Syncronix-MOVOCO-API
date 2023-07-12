package com.syncronix.movoco.repositories;

import com.syncronix.movoco.entities.Fish;
import com.syncronix.movoco.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPlantRepository extends JpaRepository<Plant, Long> {

    List<Plant> findAllByUserId(Long id);
}
