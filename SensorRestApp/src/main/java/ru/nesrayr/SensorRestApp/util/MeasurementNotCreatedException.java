package ru.nesrayr.SensorRestApp.util;

public class MeasurementNotCreatedException extends RuntimeException{
    public MeasurementNotCreatedException(String msg){
        super(msg);
    }
}
