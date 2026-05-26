package com.navneet.bfhl.service;

import com.navneet.bfhl.dto.RequestDTO;
import com.navneet.bfhl.dto.ResponseDTO;

/**
 * Service Interface for BFHL Business Logic
 * 
 * @author Navneet Junnarkar
 */
public interface BFHLService {
    
    /**
     * Process the input data and return categorized response
     * 
     * @param requestDTO Input data containing mixed array
     * @return ResponseDTO with categorized data
     */
    ResponseDTO processData(RequestDTO requestDTO);
}