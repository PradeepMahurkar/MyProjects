package com.example.institute.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.*;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class UserEntity {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Full Name is required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Full name should contain only letters and spaces.")
      @Size(min = 2, max = 45, message = "'firstname' can be minimum 6 character and maximum 45 characters")
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
      @Size(min = 8, max = 30, message = "'email' can be a minimum of 8 characters and a maximum of 25 characters")
      @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",
              message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 4 characters")
      @Pattern(regexp = "^(?=.[A-Z])(?=.[a-z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]{6,30}$",
              message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.")
    private String password;

    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number should be a 10-digit number.")
    private String contactNumber;

    @NotBlank(message = "Role is required")
    private String role;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private String dateOfBirth;

    @NotBlank(message = "Address is required")
    private String address;

//    public Object getPassword() {
//        return null;
//    }

//    public String getRole() {
//        return null;
//    }

}
