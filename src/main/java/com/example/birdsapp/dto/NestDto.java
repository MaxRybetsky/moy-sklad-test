package com.example.birdsapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * Model of Nest
 */
@Data
@Schema(title = "Nest's data model")
public class NestDto {
    @Schema(title = "Nest's id")
    private Long id;

    @Schema(title = "Nest's name")
    private String name;

    @Schema(title = "Nest's address")
    private String address;

    @Schema(title = "Birds of this nest")
    private List<BirdDto> birds;
}

