package com.zachprogramming.carcomparisonwebsite.Service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.zachprogramming.carcomparisonwebsite.Model.Car;
import org.springframework.stereotype.Service;

@Service
public class AiAnalysisService
{
    private final Client client;

    public AiAnalysisService(Client client)
    {
        this.client = client;
    }

    public String generateAiAnalysis(Car car, int valueScore)
    {
        try {
            String content = "You are a helpful car buying assistant speaking to a potential customer. " +
                    "You should only base your response off the given value score and attributes of the car. Do not mention anything " +
                    "to the customer about my algorithm." +
                    "Analyze this deal: A " + car.getFullName() + " priced at " + car.getPrice() + " USD with " + car.getHorsepower() + " and " + car.getFuelEconomy() + "mpg." +
                    "My algorithm gave it a value score of " + valueScore + " based on the following values: " +
                    "MAX_PRICE_REF = 60000, MAX_AGE_REF = 20, MIN_HORSEPOWER_REF = 60, MAX_MPG_REF = 60, " +
                    "WEIGHT_PRICE = 0.40,WEIGHT_AGE = 0.30, WEIGHT_HORSEPOWER = 0.10, WEIGHT_MPG = 0.20." +
                    "In 1 or 2 short sentences, explain if this is a good buy and why.";

            GenerateContentResponse response =
                    client.models.generateContent(
                            "gemini-2.5-flash",
                            content,
                            null);
            return response.text();
        }
        catch (Exception e)
        {
            return "AI Analysis unavailable.";
        }
    }
}
