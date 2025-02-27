package com.example.unievents.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Location {
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
    private String complement;
    private Double latitude;
    private Double longitude;
}
