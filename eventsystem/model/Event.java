package com.example.eventsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class Event {
   private String id;
   private String description;
   private int capacity;
   private LocalDate startDate;
   private LocalDate endDate;
}
