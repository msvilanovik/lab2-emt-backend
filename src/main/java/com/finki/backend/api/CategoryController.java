package com.finki.backend.api;

import com.finki.backend.domain.enumeration.BookCategory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://emt-lab2-front-end.herokuapp.com")
@RequestMapping("/api/categories")
public class CategoryController {

    @GetMapping
    public List<BookCategory> findAll() {
        return List.of(BookCategory.values());
    }
}
