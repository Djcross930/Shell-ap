package com.example.onthisday;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class OnThisDayCommandTest {

    @Autowired
    private OnThisDayCommand onThisDayCommand;

    @Test
    @Timeout(10) // Set a timeout of 10 seconds
    void eventsReturnsData() {
        String result = onThisDayCommand.events(3, 1);
        assertNotNull(result);
    }
}