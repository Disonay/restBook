package com.rest.app.controller;

import com.rest.app.dto.BookDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @PostMapping(value = "/create", consumes = "application/json")
    public void createBook(@RequestBody BookDTO bookDTO) {

    }

    @PostMapping(value = "/read", produces = "application/json")
    public void getBook(@RequestParam("bookId") Long bookId) {

    }

    @PostMapping(value = "/read", produces = "application/json")
    public void getFirstBooks(@RequestParam("number") Long number) {

    }

    @PostMapping(value = "/update", consumes = "application/json")
    public void updateBookInfo(@RequestBody BookDTO bookDTO) {

    }

    @PostMapping(value = "/clear")
    public void clear() {

    }
}
