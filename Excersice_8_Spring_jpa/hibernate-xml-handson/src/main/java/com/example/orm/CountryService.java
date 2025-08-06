package com.example.orm;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryService {

    public List<String> getAllCountries() {
        return Arrays.asList("India", "USA", "Germany", "Japan");
    }
}