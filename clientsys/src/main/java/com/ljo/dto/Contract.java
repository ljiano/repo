package com.ljo.dto;

import java.math.BigDecimal;
import java.util.Date;

public class Contract {
    private Integer id;

    private String code;

    private String name;

    private Integer companyid;

    private Integer userid;

    private BigDecimal capital;

    private BigDecimal bcapital;

    private Date createtime;

    private BigDecimal bcapitalrate;

    private BigDecimal income;

    private BigDecimal incomerate;

    private BigDecimal taxrate;

    private BigDecimal tax;

    private Integer status;

    private Integer deleteflag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public BigDecimal getBcapital() {
        return bcapital;
    }

    public void setBcapital(BigDecimal bcapital) {
        this.bcapital = bcapital;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public BigDecimal getBcapitalrate() {
        return bcapitalrate;
    }

    public void setBcapitalrate(BigDecimal bcapitalrate) {
        this.bcapitalrate = bcapitalrate;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getIncomerate() {
        return incomerate;
    }

    public void setIncomerate(BigDecimal incomerate) {
        this.incomerate = incomerate;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
    }
}