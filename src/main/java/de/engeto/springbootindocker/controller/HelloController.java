package de.engeto.springbootindocker.controller;

import de.engeto.springbootindocker.model.Book;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface HelloController {

    @Operation(summary = "Save the book", tags = "book")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200", description = "The book was added",
                            content = {
                                    @Content(   mediaType = "application/json",
                                            schema = @Schema(implementation = Book.class)
                                    ),
                                    @Content( mediaType = "application/xml",
                                            schema = @Schema(implementation = Book.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400", description = "Invalid response",
                            content = @Content
                    )
            }
    )
    Book createNewBook(@RequestBody Book book);

    @Operation(summary = "Update the book", tags = "book")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200", description = "The book was updated",
                            content = {
                                    @Content(   mediaType = "application/json",
                                            schema = @Schema(implementation = Book.class)
                                    ),
                                    @Content( mediaType = "application/xml",
                                            schema = @Schema(implementation = Book.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400", description = "Invalid response",
                            content = @Content
                    )
            }
    )
    Book updateBook(@RequestBody Book book);
}
