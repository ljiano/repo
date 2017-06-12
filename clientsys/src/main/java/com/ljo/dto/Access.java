package com.ljo.dto;

import java.math.BigDecimal;
import java.util.Date;

public class Access {
    private Integer id;

    private Integer userid;

    private Integer companyid;

    private Date accesstime;

    private Integer istaking;

    private String takingname;

    private String record;

    private Integer status;

    private BigDecimal cost;

    private Date endtime;

    private Integer isok;

    private Integer contractid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Date getAccesstime() {
        return accesstime;
    }

    public void setAccesstime(Date accesstime) {
        this.accesstime = accesstime;
    }

    public Integer getIstaking() {
        return istaking;
    }

    public void setIstaking(Integer istaking) {
        this.istaking = istaking;
    }

    public String getTakingname() {
        return takingname;
    }

    public void setTakingname(String takingname) {
        this.takingname = takingname == null ? null : takingname.trim();
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record == null ? null : record.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getIsok() {
        return isok;
    }

    public void setIsok(Integer isok) {
        this.isok = isok;
    }

    public Integer getContractid() {
        return contractid;
    }

    public void setContractid(Integer contractid) {
        this.contractid = contractid;
    }
}