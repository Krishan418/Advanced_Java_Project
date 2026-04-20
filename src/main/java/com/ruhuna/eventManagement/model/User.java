package com.ruhuna.eventManagement.model;

import com.ruhuna.eventManagement.type.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String userId;

    private String userName;

    private String telephone;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;
}
