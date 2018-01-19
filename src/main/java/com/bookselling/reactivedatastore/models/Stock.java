package com.bookselling.reactivedatastore.models;

/*
 * @author sindham
 * @date 18/12/17, 10:22 PM
 */


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "stocks")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Stock {

    @Id
    private String id;

    private Integer originalQuantity;

    private Integer orderedQuantity;

    private Date createdAt = new Date();

    private Date updatedAt = new Date();

    public Stock() {
    }

    public Stock(String id, Integer originalQuantity, Integer orderedQuantity, Date createdAt, Date updatedAt) {
        this.id = id;
        this.originalQuantity = originalQuantity;
        this.orderedQuantity = orderedQuantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOriginalQuantity() {
        return originalQuantity;
    }

    public void setOriginalQuantity(Integer originalQuantity) {
        this.originalQuantity = originalQuantity;
    }

    public Integer getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(Integer orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
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
        return "Stock{" +
                "id='" + id + '\'' +
                ", originalQuantity=" + originalQuantity +
                ", orderedQuantity=" + orderedQuantity +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
