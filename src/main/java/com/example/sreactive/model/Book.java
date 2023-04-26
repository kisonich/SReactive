package com.example.sreactive.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("books2")
public class Book {
    @Id
    private Long book_id;
    private String name;
    private String author;
    private int quantity;
    private Double price;
}
