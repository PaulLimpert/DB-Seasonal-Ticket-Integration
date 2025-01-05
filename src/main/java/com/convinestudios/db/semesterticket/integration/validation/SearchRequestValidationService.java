package com.convinestudios.db.semesterticket.integration.validation;

import com.convinestudios.db.semesterticket.integration.exception.InvalidRequestException;
import com.convinestudios.db.semesterticket.integration.model.internal.SearchRequest;
import org.springframework.stereotype.Service;

@Service
public class SearchRequestValidationService {
    public void validate(SearchRequest request) {
        switch (request.getSearchMode()) {
            case STANDARD:
                if (request.getSpecificTime() == null)
                    throw new InvalidRequestException("specificTime must be given, when the SearchMode is set to STANDARD");
                break;
            case DAILY:
                if (request.getSpecificDay() == null)
                    throw new InvalidRequestException("specificDay must be given, when the SearchMode is set to DAILY");
                break;
            case PERIODIC:
                if (request.getFromDate() == null || request.getToDate() == null)
                    throw new InvalidRequestException("fromDate and toDate must both be given, when the SearchMode is set to PERIODIC");
                if (request.getFromDate().isAfter(request.getToDate()))
                    throw new InvalidRequestException("fromDate must be before toDate");
                break;
            default:
                throw new InvalidRequestException("Unknown SearchMode");
        }
    }
}
