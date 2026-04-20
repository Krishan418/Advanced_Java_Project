package com.ruhuna.eventManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenueCreateDto {
    private String name;
    private String description;
    private String location;
    private String image;
}
