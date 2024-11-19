package de.engeto.springbootindocker.controller;

import de.engeto.springbootindocker.model.Book;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/hello")
public class HelloControllerImp implements HelloController{

    List<Book> allBooks = new ArrayList<>();

    @Value("${my.say.hello}")
    private String helloText;

    @GetMapping(value = "/message")
    public String getMessage(){
        return String.format("Hello from docker in %s.",helloText);
    }


    @Override
    @PostMapping(value = "/message")
    public Book createNewBook(@RequestBody Book book){
        allBooks.add(book);

        //exkurze
        // bez builder
        Book bookWithoutBuilder = new Book(1,"Malz princ");

        // s builder
        Book bookWithBuilder = Book.builder().bookid(1).description("Maly princ").build();

        return book;
    }

    @Override
    @PutMapping(value = "/message")
    public Book updateBook(Book book) {
        return null;
    }
}
