package com.convinestudios.db.semesterticket.integration.validation;

import com.convinestudios.db.semesterticket.integration.model.internal.properties.SearchMode;
import com.convinestudios.db.semesterticket.integration.model.internal.SearchRequest;
import org.springframework.stereotype.Service;

@Service
public class ApiKeyValidationService {

    public void validate(SearchRequest request){
        String apiKey = request.getAPI_KEY();
        SearchMode mode = request.getSearchMode();

        // todo: validation logic
    }
}
