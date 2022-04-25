package com.finki.backend;

import com.finki.backend.domain.Author;
import com.finki.backend.domain.Country;
import com.finki.backend.domain.dto.BookDto;
import com.finki.backend.domain.enumeration.BookCategory;
import com.finki.backend.service.AuthorService;
import com.finki.backend.service.BookService;
import com.finki.backend.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BackendApplication {

    private final CountryService countryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public BackendApplication(CountryService countryService, AuthorService authorService, BookService bookService) {
        this.countryService = countryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @PostConstruct
    public void init() {
        Country country = countryService.save(new Country(0L, "Poland", "Europe"));
        authorService.save(new Author(0L, "Andrzej", "Sapkowski", country));

        country = countryService.save(new Country(0L, "United Kingdom", "Europe"));
        authorService.save(new Author(0L, "J. R. R.", "Tolkien", country));
        authorService.save(new Author(0L, "J.K.", "Rowling", country));

        bookService.save(new BookDto("The Witcher", BookCategory.FANTASY, 1L, 5));
        bookService.save(new BookDto("Sword of Destiny", BookCategory.FANTASY, 1L, 5));
        bookService.save(new BookDto("The Last Wish", BookCategory.FANTASY, 1L, 5));
        bookService.save(new BookDto("Blood of Elves", BookCategory.FANTASY, 1L, 5));
        bookService.save(new BookDto("Time of Contempt", BookCategory.FANTASY, 1L, 5));
        bookService.save(new BookDto("Baptism of Fire", BookCategory.FANTASY, 1L, 5));
        bookService.save(new BookDto("The Tower of the Swallow", BookCategory.FANTASY, 1L, 5));
        bookService.save(new BookDto("The Lady of the Lake", BookCategory.FANTASY, 1L, 5));
        bookService.save(new BookDto("Season of Storms", BookCategory.FANTASY, 1L, 5));
        bookService.save(new BookDto("The Lord of the Rings", BookCategory.FANTASY, 2L, 5));
        bookService.save(new BookDto("Harry Potter and the Philosopher's Stone", BookCategory.FANTASY, 3L, 5));
        bookService.save(new BookDto("Harry Potter and the Chamber of Secrets", BookCategory.FANTASY, 3L, 5));
        bookService.save(new BookDto("Harry Potter and the Prisoner of Azkaban", BookCategory.FANTASY, 3L, 5));
        bookService.save(new BookDto("Harry Potter and the Goblet of Fire", BookCategory.FANTASY, 3L, 5));
        bookService.save(new BookDto("Harry Potter and the Order of the Phoenix", BookCategory.FANTASY, 3L, 5));
        bookService.save(new BookDto("Harry Potter and the Half-Blood Prince", BookCategory.FANTASY, 3L, 5));
        bookService.save(new BookDto("Harry Potter and the Deathly Hallows", BookCategory.FANTASY, 3L, 5));
    }
}
