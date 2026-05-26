package com.navneet.bfhl.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Request DTO for BFHL API
 * 
 * @author Navneet Junnarkar
 */
public class RequestDTO {
    
    @NotNull(message = "Data field is required")
    @NotEmpty(message = "Data array cannot be empty")
    private List<String> data;

    // Default constructor
    public RequestDTO() {}

    // Constructor with parameters
    public RequestDTO(List<String> data) {
        this.data = data;
    }

    // Getter
    public List<String> getData() {
        return data;
    }

    // Setter
    public void setData(List<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "data=" + data +
                '}';
    }
}