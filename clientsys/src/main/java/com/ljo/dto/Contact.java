package com.ljo.dto;

public class Contact {
    private Integer id;

    private String contactname;

    private String contactposition;

    private String contacttel;

    private String contactphone;

    private String contactno;

    private String contactemail;

    private Integer iscore;

    private Integer companyid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname == null ? null : contactname.trim();
    }

    public String getContactposition() {
        return contactposition;
    }

    public void setContactposition(String contactposition) {
        this.contactposition = contactposition == null ? null : contactposition.trim();
    }

    public String getContacttel() {
        return contacttel;
    }

    public void setContacttel(String contacttel) {
        this.contacttel = contacttel == null ? null : contacttel.trim();
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone == null ? null : contactphone.trim();
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno == null ? null : contactno.trim();
    }

    public String getContactemail() {
        return contactemail;
    }

    public void setContactemail(String contactemail) {
        this.contactemail = contactemail == null ? null : contactemail.trim();
    }

    public Integer getIscore() {
        return iscore;
    }

    public void setIscore(Integer iscore) {
        this.iscore = iscore;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }
}