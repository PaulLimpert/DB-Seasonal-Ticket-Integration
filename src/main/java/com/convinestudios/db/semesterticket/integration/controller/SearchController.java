package com.convinestudios.db.semesterticket.integration.controller;

import com.convinestudios.db.semesterticket.integration.model.internal.SearchRequest;
import com.convinestudios.db.semesterticket.integration.model.internal.SearchResponse;
import com.convinestudios.db.semesterticket.integration.validation.ApiKeyValidationService;
import com.convinestudios.db.semesterticket.integration.validation.SearchRequestValidationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    private final ApiKeyValidationService apiKeyValidationService;
    private final SearchRequestValidationService searchRequestValidationService;

    @Autowired
    public SearchController(ApiKeyValidationService apiKeyValidationService,
                            SearchRequestValidationService searchRequestValidationService) {
        this.apiKeyValidationService = apiKeyValidationService;
        this.searchRequestValidationService = searchRequestValidationService;
    }

    // Standard welcome message
    @GetMapping("/")
    public String welcome() {
        return "Welcome to the Semesterticket integration service by Paul Limpert";
    }

    // Request prices
    @PostMapping("/search")
    public SearchResponse search(@Valid @RequestBody SearchRequest searchRequest) {
        apiKeyValidationService.validate(searchRequest);
        searchRequestValidationService.validate(searchRequest);
        // todo: use bean of ExternalApiService (Deutsche Bahn defined) and send a post request
        return null;
    }
}
