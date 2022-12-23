package com.priyajit.ticketservice.service;

import com.priyajit.ticketservice.entity.RequestCategory;
import com.priyajit.ticketservice.repository.RequestCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestCategoryService {

    @Autowired
    private RequestCategoryRepository requestCategoryRepository;

    private List<RequestCategory> requestCategories;

    private void loadRequestCategories() {
        requestCategories = requestCategoryRepository.findAll();
    }

    public RequestCategory getRequestCategoryByCategoryId(Integer categoryId) {
        if(requestCategories == null) loadRequestCategories();
        return requestCategories.stream()
                .filter(requestCategory -> requestCategory.getCategoryId().equals(categoryId))
                .toList().get(0);
    }
}
