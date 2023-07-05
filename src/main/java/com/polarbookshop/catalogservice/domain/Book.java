package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Book(
        @NotBlank(message = "ISBN is required")
        @Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$", message = "ISBN format is incorrect")
        String isbn,
        @NotBlank(message = "Title is required")
        String title,
        @NotBlank(message = "Author is required")
        String author,
        @NotNull(message = "Price is required")
        @Positive(message = "Price must be greater than zero")
        Double price
) {
}
