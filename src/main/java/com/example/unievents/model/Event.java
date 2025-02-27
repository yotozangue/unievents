package com.example.unievents.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String title;

    @Embedded
    private Location location;

    @ElementCollection
    private List<String> socialNetworks;

    private String website;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;
}
