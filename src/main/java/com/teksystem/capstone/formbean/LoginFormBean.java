package com.teksystem.capstone.formbean;

import com.teksystem.capstone.validation.EmailUnique;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class LoginFormBean {

    @NotBlank(message = "Email is required")
    @Email(message = "@Email from spring validator")
//    @Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}\n", message = "Email format invalid")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;
}
