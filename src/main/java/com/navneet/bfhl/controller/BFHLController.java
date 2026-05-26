package com.navneet.bfhl.controller;

import com.navneet.bfhl.dto.RequestDTO;
import com.navneet.bfhl.dto.ResponseDTO;
import com.navneet.bfhl.service.BFHLService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller for BFHL API
 * 
 * @author Navneet Junnarkar
 */
@RestController
@RequestMapping("/bfhl")
@CrossOrigin(origins = "*")
public class BFHLController {

    private final BFHLService bfhlService;

    // Constructor injection (no Lombok @RequiredArgsConstructor)
    public BFHLController(BFHLService bfhlService) {
        this.bfhlService = bfhlService;
    }

    /**
     * POST endpoint to process mixed data array
     * 
     * @param requestDTO Input data containing mixed array
     * @return ResponseDTO with categorized data
     */
    @PostMapping
    public ResponseEntity<ResponseDTO> processData(@Valid @RequestBody RequestDTO requestDTO) {
        System.out.println("Received POST request with data: " + requestDTO.getData());
        
        ResponseDTO response = bfhlService.processData(requestDTO);
        
        System.out.println("Successfully processed data for user: " + response.getUser_id());
        return ResponseEntity.ok(response);
    }

    /**
     * GET endpoint for operation code (if needed for frontend)
     * 
     * @return Simple operation code response
     */
    @GetMapping
    public ResponseEntity<Map<String, String>> getOperationCode() {
        Map<String, String> response = new HashMap<>();
        response.put("operation_code", "1");
        return ResponseEntity.ok(response);
    }
}