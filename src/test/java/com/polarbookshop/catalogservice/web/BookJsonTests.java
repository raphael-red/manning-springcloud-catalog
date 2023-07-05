package com.polarbookshop.catalogservice.web;

import com.polarbookshop.catalogservice.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class BookJsonTests {

    @Autowired
    private JacksonTester<Book> json;

    @Test
    void testSerialize() throws Exception {
        Book book = new Book("1234567890", "Title", "Author", 9.90);
        JsonContent<Book> jsonBook = json.write(book);
        assertThat(jsonBook)
                .extractingJsonPathStringValue("@.isbn").isEqualTo(book.isbn());
        assertThat(jsonBook)
                .extractingJsonPathStringValue("@.title").isEqualTo(book.title());
        assertThat(jsonBook)
                .extractingJsonPathStringValue("@.author").isEqualTo(book.author());
        assertThat(jsonBook).extractingJsonPathNumberValue("@.price").isEqualTo(book.price());
    }
}
