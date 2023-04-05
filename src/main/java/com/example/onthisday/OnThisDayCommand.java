package com.example.onthisday;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.web.client.RestTemplate;

@ShellComponent
public class OnThisDayCommand {
    @ShellMethod("Prints events from https://byabbe.se/on-this-day/{month}/{day}/events.json") //Run events in shell along with a month and date. for example, type in "events 3 1" to receive the full JSON response of events on March 1st
    public String events(int month, int day) {
        String url = String.format("https://byabbe.se/on-this-day/%d/%d/events.json", month, day);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        return response; //need to further parse the response to include only title and description, right now it has full JSON response only
    }
}
