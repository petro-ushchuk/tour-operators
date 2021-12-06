package com.example.touroperators.dto;

import com.example.touroperators.dto.validation.FieldMatch;
import com.example.touroperators.dto.validation.UniqueUsername;
import com.example.touroperators.dto.validation.group.OnCreate;
import com.example.touroperators.dto.validation.group.OnRegister;
import com.example.touroperators.dto.validation.group.OnSignIn;
import com.example.touroperators.dto.validation.group.OnUpdate;
import com.example.touroperators.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Data
@FieldMatch(first = "password", second = "repeatPassword",
        groups = OnRegister.class, message = "{password.field.not.match}")

public class UserDto {

    @NotNull(groups = OnUpdate.class, message = "{user.id.blank}")
    @Null(groups = OnCreate.class, message = "{user.id.not.null}")
    private Long id;

    @NotBlank(groups = OnRegister.class, message = "{firstname.blank}")
    @Null(groups = {OnSignIn.class}, message = "{firstname.not.null}")
    private String firstName;

    @NotBlank(groups = OnRegister.class, message = "{lastname.blank}")
    @Null(groups = {OnSignIn.class}, message = "{lastname.not.null}")
    private String lastName;

    @JsonProperty(access = WRITE_ONLY)
    @NotBlank(groups = {OnRegister.class, OnSignIn.class, OnUpdate.class}, message = "{password.blank}")
    private String password;

    @JsonProperty(access = WRITE_ONLY)
    @Null(groups = OnSignIn.class, message = "{repeatPassword.not.null}")
    @NotBlank(groups = {OnRegister.class, OnUpdate.class}, message = "{repeatPassword.blank}")
    private String repeatPassword;

    @NotBlank(groups = {OnRegister.class, OnSignIn.class, OnUpdate.class}, message = "{username.blank}")
    @UniqueUsername(groups = {OnRegister.class, OnUpdate.class})
    private String username;

    @Null(groups = {OnSignIn.class}, message = "{birthdate.not.null}")
    @NotNull(groups = OnRegister.class, message = "{birthdate.blank}")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;

    @Null(groups = {OnSignIn.class, OnRegister.class, OnUpdate.class}, message = "{tours.not.null}")
    private List<TourDto> tours;

    @Null(groups = {OnSignIn.class, OnRegister.class}, message = "{role.blank}")
    private Role role;
}
