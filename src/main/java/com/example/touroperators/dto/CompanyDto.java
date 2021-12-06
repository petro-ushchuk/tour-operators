package com.example.touroperators.dto;

import com.example.touroperators.dto.validation.group.OnCreate;
import com.example.touroperators.dto.validation.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
public class CompanyDto {
    @NotNull(groups = OnUpdate.class, message = "{user.id.blank}")
    @Null(groups = OnCreate.class, message = "{user.id.not.null}")
    private Long id;
    @NotBlank(groups = OnCreate.class, message = "{company.name.blank}")
    private String companyName;
    @JsonProperty(access = READ_ONLY)
    private UserDto owner;
    @JsonProperty(access = READ_ONLY)
    private List<TourDto> tours;
}

