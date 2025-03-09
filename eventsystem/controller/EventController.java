package com.example.eventsystem.controller;

import com.example.eventsystem.Api.ApiResponse;
import com.example.eventsystem.model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@RestController
@RequestMapping("/aoi/v1/event")
public class EventController {

    ArrayList<Event> events = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Event> getEvents() {
        return events;
    }

    @PostMapping("/add")
    public ApiResponse addEvents(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("events added Successfully");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateEvents(@PathVariable int index, @RequestBody Event event) {
        events.set(index, event);
        return new ApiResponse("events updated Successfully");
    }

    @DeleteMapping("/delete{index}")
    public ApiResponse deleteEvents(@PathVariable int index) {
        events.remove(index);
        return new ApiResponse("events deleted successfully");
    }

    @PutMapping("/change/{id}")
    public ApiResponse changeCapacity(@PathVariable String id, @RequestBody int newCapacity) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId().equals(id)) {
                events.get(i).setCapacity(newCapacity);
                return new ApiResponse("capacity changed successfully");
            }

        }
        return new ApiResponse("event not found");
    }
    @GetMapping("/search/{id}")
    public ArrayList<Event> searchEvent(@PathVariable String id){
        ArrayList<Event> result = new ArrayList<>();
        for(Event event:events){
            if(event.getId().equals(id)){
                result.add(event);
            }
        }
        return result;
    }
}
