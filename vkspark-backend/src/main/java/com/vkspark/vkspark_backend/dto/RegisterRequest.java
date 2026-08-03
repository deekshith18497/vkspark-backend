package com.vkspark.vkspark_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterRequest {

    @NotBlank(message = "Full Name is Required")
    @Size(min = 3, max = 50, message = "Name should be between 3 and 50 characters")
    private String fullName;

    @NotBlank(message = "Email is Required")
    @Email(message = "Invalid Email")
    private String email;

    @NotBlank(message = "Password is Required")
    @Size(min = 6, max = 20, message = "Password should be between 6 and 20 characters")
    private String password;

    @NotBlank(message = "Phone Number is Required")
    @Pattern(
            regexp = "^[6-9][0-9]{9}$",
            message = "Invalid Phone Number")
    private String phone;

    public RegisterRequest() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
