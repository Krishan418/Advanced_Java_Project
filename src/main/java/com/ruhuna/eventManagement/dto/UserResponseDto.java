package com.ruhuna.eventManagement.dto;

import com.ruhuna.eventManagement.type.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private String userId;
    private String userName;
    private String telephone;
    private String email;
    private Role role;
}
