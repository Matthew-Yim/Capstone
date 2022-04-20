package com.teksystem.capstone.formbean;

import com.teksystem.capstone.validation.EmailUnique;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class RegisterFormBean {

    // this id will be null in the case of a crete
    // and will be populated with the user id in the ase of an edit
    private Integer id;

    @EmailUnique(message = "Email already exists in the database")
    @NotBlank(message = "Email is required")
    @Email(message = "@Email from spring validator")
    @Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}\n", message = "Email format invalid")
    private String email;

    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Confirm Password is required")
    private String confirmPassword;

//    @AssertTrue(message = "Checkbox is required")
//    private boolean checkbox;
}