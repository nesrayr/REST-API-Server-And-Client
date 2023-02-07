package ru.nesrayr.SensorRestApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nesrayr.SensorRestApp.models.Measurement;
import ru.nesrayr.SensorRestApp.repositories.MeasurementsRepository;
import ru.nesrayr.SensorRestApp.repositories.SensorsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementsService {
    private final MeasurementsRepository measurementsRepository;
    private final SensorsRepository sensorsRepository;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementsRepository, SensorsRepository sensorsRepository) {
        this.measurementsRepository = measurementsRepository;
        this.sensorsRepository = sensorsRepository;
    }

    @Transactional
    public void save(Measurement measurement){
        enrichMeasurement(measurement);
        measurementsRepository.save(measurement);
    }

    public List<Measurement> findAll(){
        return measurementsRepository.findAll();
    }

    public long rainyDays(){
        return measurementsRepository.findAll().stream().filter((Measurement::getRaining)).count();
    }

    private void enrichMeasurement(Measurement measurement){
        measurement.setSensor(sensorsRepository.findByName(measurement.getSensor().getName()).get());
        measurement.setCreatedAt(LocalDateTime.now());
    }
}
