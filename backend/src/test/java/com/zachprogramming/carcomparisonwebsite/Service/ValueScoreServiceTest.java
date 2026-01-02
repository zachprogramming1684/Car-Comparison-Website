package com.zachprogramming.carcomparisonwebsite.Service;

import com.zachprogramming.carcomparisonwebsite.DTO.ValueScoreDTO;
import com.zachprogramming.carcomparisonwebsite.Model.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ValueScoreServiceTest
{
    @Mock
    private AiAnalysisService aiAnalysisService;
    @InjectMocks
    private ValueScoreService valueScoreService;

    @Test
    void shouldCalculateValueScore()
    {
        Car car = new Car("Test", "Car", Year.now().getValue(), "Red", 30000, 200, 30, "Trim");
        car.setId(1L);

        when(aiAnalysisService.generateAiAnalysis(any(Car.class), anyInt())).thenReturn("Good buy");

        ValueScoreDTO result = valueScoreService.generateValueScore(car);

        assertNotNull(result);
        assertTrue(result.getValueScore() >= 0 && result.getValueScore() <= 100);
        assertEquals("Good buy", result.getAiAnalysis());
    }
}