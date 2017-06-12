package com.ljo.dto;

import java.math.BigDecimal;

public class Product {
    private Integer id;

    private String name;

    private Integer type;

    private BigDecimal price;

    private String description;

    private Integer creditid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getCreditid() {
        return creditid;
    }

    public void setCreditid(Integer creditid) {
        this.creditid = creditid;
    }
}