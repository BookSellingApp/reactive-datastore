package com.bookselling.reactivedatastore.models;

/*
 * @author sindham
 * @date 18/12/17, 10:28 PM
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "orders")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Order {

    @Id
    private String id;

    private List<Book> books;

    private Date createdAt = new Date();

    private Date updatedAt = new Date();

    public Order() {
    }

    public Order(String id, List<Book> books, Date createdAt, Date updatedAt) {
        this.id = id;
        this.books = books;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", books=" + books +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
