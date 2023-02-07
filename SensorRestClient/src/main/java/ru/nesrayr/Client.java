package ru.nesrayr;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Client {
    static RestTemplate restTemplate = new RestTemplate();
    public static void main(String[] args) {
        String sensorName = "sensor2";
//        sensorReg(sensorName);
        Random random = new Random();
        double maxTemperature = 50.0;
//        for(int i=0; i<1000; i++){
//            System.out.println(i);
//            sendMeasurements(random.nextDouble()*maxTemperature, random.nextBoolean(), sensorName);
//        }
//        getMeasurements();
    }

    private static void sensorReg(String sensorName) {
        String url = "http://localhost:8080/sensors/registration";

        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("name", sensorName);
        makePostRequest(url, jsonData);
    }

    private static void sendMeasurements(double value, boolean raining, String sensorName){
        String url = "http://localhost:8080/measurements/add";
        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("value", value);
        jsonData.put("raining", raining);
        jsonData.put("sensor", Map.of("name", sensorName));
        makePostRequest(url, jsonData);
    }

    private static void getMeasurements(){
        String url = "http://localhost:8080/measurements";
        System.out.println(restTemplate.getForObject(url, String.class));
    }

    private static void makePostRequest(String url, Map<String, Object> jsonData){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<>(jsonData, headers);
        try {
            restTemplate.postForObject(url, request, String.class);
            System.out.println("Успешно отправлено на сервер");
        } catch (HttpClientErrorException e) {
            System.out.println("Error!");
            System.out.println(e.getMessage());
        }

    }
}
