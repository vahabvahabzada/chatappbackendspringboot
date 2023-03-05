package com.example.chatappbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatappbackend.repos.SearchRepo;

@Service
public class SearchService {
    @Autowired
    private SearchRepo repo;

    public List<String> istifadeciAxtar(String searchText) {
        System.out.println(searchText);
        return repo.istifadeciAxtar(searchText);
    }
}
