package de.engeto.springbootindocker.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {

    @Schema(description = "this is unique id of book", example = "11001")
    private int bookid;

    private String description;


}


