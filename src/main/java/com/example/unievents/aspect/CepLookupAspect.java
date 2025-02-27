package com.example.unievents.aspect;

import com.example.unievents.model.Event;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public class CepLookupAspect {

    private static final Logger logger = LoggerFactory.getLogger(CepLookupAspect.class);
    private static final String CEP_API_URL = "https://www.cepaberto.com/api/v3/cep?cep=";

    @Value("${TOKEN_CEPABERTO}")
    private static String token;

    @Before("execution(* com.example.unievents.service.EventService.createEvent(..)) || execution(* com.example.unievents.service.EventService.updateEvent(..))")
    public void fetchCoordinates(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Event event = (Event) args[0];

        if (event.getLocation() != null && event.getLocation().getZipCode() != null && !event.getLocation().getZipCode().isEmpty()) {
            String cep = event.getLocation().getZipCode();
            String url = CEP_API_URL + cep;

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Token token=" + token);
            HttpEntity<String> requestEntity = new HttpEntity<>(headers);



        } else {
            // cep não informado
        }
    }

}
