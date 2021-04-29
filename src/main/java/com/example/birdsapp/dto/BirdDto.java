package com.example.birdsapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Model of Bird.
 */
@Data
@Schema(title = "Bird's data model")
public class BirdDto {
    @Schema(title = "Bird's id")
    private Long id;

    @Schema(title = "Bird's name")
    private String name;

    @Schema(title = "Bird's color")
    private String color;

    @Schema(title = "Bird can fly")
    private Boolean fly;

    @Schema(title = "Bird's nest ID")
    private NestDto nest;
}
