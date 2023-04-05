package com.example.onthisday;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.web.client.RestTemplate;
//TO DO - I WANT TO HAVE THE EVENT METHOD CALLED ON APP START, AND HAVE IT RESPONSIVE TO A USERS INPUT, RATHER THAN HAVING THE USER CALL THE METHOD WITH FORMATTED INPUT
@ShellComponent
public class OnThisDayCommand {
    @ShellMethod("Prints events from https://byabbe.se/on-this-day/{month}/{day}/events.json") //Run events method in shell along with a month and date. for example, type in "events 3 1" to receive the full JSON response of events on March 1st
    public String events(int month, int day) {
        String url = String.format("https://byabbe.se/on-this-day/%d/%d/events.json", month, day);
        RestTemplate restTemplate = new RestTemplate(); //RestTemplate is a built-in feature of spring web, it's used to help handle/parse the JSON response
        String response = restTemplate.getForObject(url, String.class);
        return response; //need to further parse the response to include only title and description, right now it has full JSON response only
    }
}
