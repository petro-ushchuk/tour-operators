package com.example.touroperators.dto;

import com.example.touroperators.dto.validation.group.OnCreate;
import com.example.touroperators.dto.validation.group.OnUpdate;
import com.example.touroperators.model.enums.TourType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
public class TourDto {
    @NotNull(groups = OnUpdate.class, message = "{tour.id.blank}")
    @Null(groups = OnCreate.class, message = "{tour.id.not.null}")
    private Long id;
    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "{tour.name.blank}")
    private String name;
    @NotNull(groups = {OnCreate.class, OnUpdate.class}, message = "{tour.type.blank}")
    private TourType tourType;
    @NotNull(groups = {OnCreate.class, OnUpdate.class}, message = "{tour.company.blank}")
    private CompanyDto company;
    @JsonProperty(access = READ_ONLY)
    private List<UserDto> participants;
}
