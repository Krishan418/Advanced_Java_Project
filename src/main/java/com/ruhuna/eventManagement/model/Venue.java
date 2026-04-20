package com.ruhuna.eventManagement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "venues")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venue {

    @Id
    private String venueId;

    private String name;

    private String description;

    private String location;

    private boolean isBooked;

    private String image;
}
