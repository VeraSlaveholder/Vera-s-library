package example.models;

import javax.validation.constraints.*;

public class Book {
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters")
    private String name;

    @NotEmpty(message = "Author should not be empty")
    private String author;

    @Min(value = 100, message = "Age should be greater than 100")
    private int year_of_production;

    public Book() {

    }

    public Book(String name, String author, int year_of_production) {
        this.name = name;
        this.author = author;
        this.year_of_production = year_of_production;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear_of_production() {
        return year_of_production;
    }

    public void setYear_of_production(int year_of_production) {
        this.year_of_production = year_of_production;
    }

}
