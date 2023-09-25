package com.jwt.auth.Jwt;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "user_tbl")
public class User {

    @Id
    @GeneratedValue()
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String password;
    private Set<String> role;
}
