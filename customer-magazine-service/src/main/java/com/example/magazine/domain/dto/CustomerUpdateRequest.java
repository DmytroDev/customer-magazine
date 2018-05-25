package com.example.magazine.domain.dto;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerUpdateRequest {

    @NotEmpty
    private Long id;

    @NotEmpty
    @Size(max = 100)
    protected String firstName;

    @NotEmpty
    @Size(max = 100)
    protected String lastName;

    @Email
    protected String email;

    protected String phone;
}
