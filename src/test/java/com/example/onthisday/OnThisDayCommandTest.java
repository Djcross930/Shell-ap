package com.example.onthisday;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OnThisDayCommandTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private OnThisDayCommand onThisDayCommand;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testEvents() {
        int month = 3;
        int day = 1;
        String expectedResponse = "{\"events\": [\"sample event\"]}";

        Mockito.lenient().when(restTemplate.getForObject(any(String.class), eq(String.class))).thenReturn(expectedResponse);

        String actualResponse = onThisDayCommand.events(month, day);

        assertNotNull(actualResponse, "The response should not be null");
    }
}
