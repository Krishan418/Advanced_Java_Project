package com.ruhuna.eventManagement.dto;

import com.ruhuna.eventManagement.type.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {
    private String userName;
    private String telephone;
    private String email;
    private Role role;
}
