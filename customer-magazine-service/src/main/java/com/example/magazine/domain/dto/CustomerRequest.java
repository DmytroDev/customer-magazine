package com.example.magazine.domain.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CustomerRequest {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;
    private String phone;
}
