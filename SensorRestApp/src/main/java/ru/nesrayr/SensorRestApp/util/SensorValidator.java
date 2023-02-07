package ru.nesrayr.SensorRestApp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.nesrayr.SensorRestApp.models.Sensor;
import ru.nesrayr.SensorRestApp.repositories.SensorsRepository;

import java.time.Period;
@Component
public class SensorValidator implements Validator {
    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorValidator(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;
        if(sensorsRepository.findByName(sensor.getName()).isPresent()){
            errors.rejectValue("name", "Sensor with this name already exists");
        }
    }
}
