package com.ruhuna.eventManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VenueResponseDto {
    private String venueId;
    private String name;
    private String description;
    private String location;
    private boolean isBooked;
    private String image;
}
