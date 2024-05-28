package com.clinics.farabi.patients;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record PatientRequest(@JsonProperty("first_name") @NotBlank(message = "First name is required") String firstName,
                             @JsonProperty("last_name") @NotEmpty(message = "Last name is required") String lastName,
                             @Email(message = "Invalid email address provided", regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$") String email,
                             @NotEmpty(message = "Phone number is required") String phone,
                             @Size(min = 8, message = "password must be at least 8 characters in length") String password,
                             @Positive(message = "Please enter a valid age") Integer age) {
}
