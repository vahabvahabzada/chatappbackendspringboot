package com.example.chatappbackend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatappbackend.services.SearchService;

@RestController
public class SearchController {
    private final SearchService service;
    public SearchController(SearchService service){
        this.service=service;
    }

    @PostMapping("/search")
    public List<String> istifadeciAxtar(@RequestBody String searchText) {
        return service.istifadeciAxtar(searchText);
    }
}
