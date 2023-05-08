package com.example.chatappbackend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.chatappbackend.repos.SearchRepo;

@Service
public class SearchService {
    private final SearchRepo repo;
    public SearchService(SearchRepo repo){
        this.repo=repo;
    }

    public List<String> istifadeciAxtar(String searchText) {
        System.out.println(searchText);
        return repo.istifadeciAxtar(searchText);
    }
}
