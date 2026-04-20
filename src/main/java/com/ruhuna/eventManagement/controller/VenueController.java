package com.ruhuna.eventManagement.controller;

import com.ruhuna.eventManagement.dto.ApiResponse;
import com.ruhuna.eventManagement.dto.ResponseUtil;
import com.ruhuna.eventManagement.dto.VenueCreateDto;
import com.ruhuna.eventManagement.dto.VenueResponseDto;
import com.ruhuna.eventManagement.service.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/venues")
@RequiredArgsConstructor
public class VenueController {

    private final VenueService venueService;

    @PostMapping
    public ApiResponse<VenueResponseDto> createVenue(@RequestBody VenueCreateDto venueCreateDto) {
        VenueResponseDto createdVenue = venueService.createVenue(venueCreateDto);
        return ResponseUtil.success("Venue created successfully", createdVenue, null);
    }

    @GetMapping
    public ApiResponse<List<VenueResponseDto>> getAllVenues() {
        List<VenueResponseDto> venues = venueService.getAllVenues();
        return ResponseUtil.success("Venues retrieved successfully", venues, null);
    }

    @GetMapping("/{venueId}")
    public ApiResponse<VenueResponseDto> getVenueById(@PathVariable String venueId) {
        VenueResponseDto venue = venueService.getVenueById(venueId);
        return ResponseUtil.success("Venue retrieved successfully", venue, null);
    }

    @PutMapping("/{venueId}")
    public ApiResponse<VenueResponseDto> updateVenue(@PathVariable String venueId, @RequestBody VenueCreateDto venueCreateDto) {
        VenueResponseDto updatedVenue = venueService.updateVenue(venueId, venueCreateDto);
        return ResponseUtil.success("Venue updated successfully", updatedVenue, null);
    }

    @DeleteMapping("/{venueId}")
    public ApiResponse<Void> deleteVenue(@PathVariable String venueId) {
        venueService.deleteVenue(venueId);
        return ResponseUtil.success("Venue deleted successfully", null, null);
    }
}
