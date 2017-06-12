package com.ljo.dto;

import java.math.BigDecimal;

public class Attachment {
    private Integer id;

    private Integer umid;

    private String umentity;

    private Integer type;

    private String name;

    private BigDecimal contentsize;

    private byte[] content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUmid() {
        return umid;
    }

    public void setUmid(Integer umid) {
        this.umid = umid;
    }

    public String getUmentity() {
        return umentity;
    }

    public void setUmentity(String umentity) {
        this.umentity = umentity == null ? null : umentity.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getContentsize() {
        return contentsize;
    }

    public void setContentsize(BigDecimal contentsize) {
        this.contentsize = contentsize;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}