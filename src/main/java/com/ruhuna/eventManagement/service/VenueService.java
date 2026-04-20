package com.ruhuna.eventManagement.service;

import com.ruhuna.eventManagement.dto.VenueCreateDto;
import com.ruhuna.eventManagement.dto.VenueResponseDto;
import com.ruhuna.eventManagement.model.Venue;
import com.ruhuna.eventManagement.repository.VenueRepository;
import com.ruhuna.eventManagement.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VenueService {

    private final VenueRepository venueRepository;

    public VenueResponseDto createVenue(VenueCreateDto dto) {
        Venue venue = Venue.builder()
                .venueId(IdGenerator.generateVenueId())
                .name(dto.getName())
                .description(dto.getDescription())
                .location(dto.getLocation())
                .isBooked(false)
                .image(dto.getImage())
                .build();
        
        Venue savedVenue = venueRepository.save(venue);
        return mapToResponseDto(savedVenue);
    }

    public List<VenueResponseDto> getAllVenues() {
        return venueRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    public VenueResponseDto getVenueById(String venueId) {
        Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new RuntimeException("Venue not found with id: " + venueId));
        return mapToResponseDto(venue);
    }

    public VenueResponseDto updateVenue(String venueId, VenueCreateDto dto) {
        Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new RuntimeException("Venue not found with id: " + venueId));
        
        venue.setName(dto.getName());
        venue.setDescription(dto.getDescription());
        venue.setLocation(dto.getLocation());
        venue.setImage(dto.getImage());
        
        Venue updatedVenue = venueRepository.save(venue);
        return mapToResponseDto(updatedVenue);
    }

    public void deleteVenue(String venueId) {
        if (!venueRepository.existsById(venueId)) {
            throw new RuntimeException("Venue not found with id: " + venueId);
        }
        venueRepository.deleteById(venueId);
    }

    private VenueResponseDto mapToResponseDto(Venue venue) {
        return VenueResponseDto.builder()
                .venueId(venue.getVenueId())
                .name(venue.getName())
                .description(venue.getDescription())
                .location(venue.getLocation())
                .isBooked(venue.isBooked())
                .image(venue.getImage())
                .build();
    }
}
