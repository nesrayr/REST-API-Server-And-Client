package ru.nesrayr.SensorRestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nesrayr.SensorRestApp.models.Measurement;
import ru.nesrayr.SensorRestApp.models.Sensor;

@Repository
public interface MeasurementsRepository extends JpaRepository<Measurement, Integer> {

}
