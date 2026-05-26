package com.navneet.bfhl.service.impl;

import com.navneet.bfhl.dto.RequestDTO;
import com.navneet.bfhl.dto.ResponseDTO;
import com.navneet.bfhl.service.BFHLService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service Implementation for BFHL Business Logic
 * 
 * @author Navneet Junnarkar
 */
@Service
public class BFHLServiceImpl implements BFHLService {

    private static final String USER_ID = "navneet_junnarkar";
    private static final String EMAIL = "navneetjunnarkar230210@acropolis.in";
    private static final String ROLL_NUMBER = "0827CY231047";

    @Override
    public ResponseDTO processData(RequestDTO requestDTO) {
        System.out.println("Processing data with " + requestDTO.getData().size() + " elements");
        
        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();
        
        long sum = 0;
        
        // Process each element in the data array
        for (String element : requestDTO.getData()) {
            if (element == null || element.isEmpty()) {
                continue;
            }
            
            if (isNumeric(element)) {
                long number = Long.parseLong(element);
                sum += number;
                
                if (number % 2 == 0) {
                    evenNumbers.add(element);
                } else {
                    oddNumbers.add(element);
                }
            } else if (isAlphabet(element)) {
                alphabets.add(element.toUpperCase());
            } else {
                specialCharacters.add(element);
            }
        }
        
        // Generate concat_string from alphabets
        String concatString = generateConcatString(alphabets);
        
        return ResponseDTO.builder()
                .is_success(true)
                .user_id(USER_ID)
                .email(EMAIL)
                .roll_number(ROLL_NUMBER)
                .odd_numbers(oddNumbers)
                .even_numbers(evenNumbers)
                .alphabets(alphabets)
                .special_characters(specialCharacters)
                .sum(String.valueOf(sum))
                .concat_string(concatString)
                .build();
    }
    
    /**
     * Check if string is numeric
     */
    private boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Check if string is alphabet (single character)
     */
    private boolean isAlphabet(String str) {
        return str.length() == 1 && Character.isLetter(str.charAt(0));
    }
    
    /**
     * Generate concat string from alphabets
     * 1. Collect all alphabets
     * 2. Reverse them
     * 3. Apply alternating caps
     */
    private String generateConcatString(List<String> alphabets) {
        if (alphabets.isEmpty()) {
            return "";
        }
        
        // Join all alphabets
        StringBuilder sb = new StringBuilder();
        for (String alphabet : alphabets) {
            sb.append(alphabet);
        }
        
        // Reverse the string
        String reversed = sb.reverse().toString();
        
        // Apply alternating caps (first char uppercase, second lowercase, etc.)
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            char ch = reversed.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(Character.toLowerCase(ch));
            }
        }
        
        return result.toString();
    }
}