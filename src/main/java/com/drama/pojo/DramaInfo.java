package com.drama.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class DramaInfo {
    
    private Long id;

    private Date createTime;

    private String setIp;

    private String isHot;

    private Integer customerNum;

    private Long typeId;

    private String duration;

    private BigDecimal price;

    private String description;

    public Long getId() {
        return id;
    }

    public DramaInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public DramaInfo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getSetIp() {
        return setIp;
    }

    public DramaInfo setSetIp(String setIp) {
        this.setIp = setIp == null ? null : setIp.trim();
        return this;
    }

    public String getIsHot() {
        return isHot;
    }

    public DramaInfo setIsHot(String isHot) {
        this.isHot = isHot == null ? null : isHot.trim();
        return this;
    }

    public Integer getCustomerNum() {
        return customerNum;
    }

    public DramaInfo setCustomerNum(Integer customerNum) {
        this.customerNum = customerNum;
        return this;
    }

    public Long getTypeId() {
        return typeId;
    }

    public DramaInfo setTypeId(Long typeId) {
        this.typeId = typeId;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public DramaInfo setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DramaInfo setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DramaInfo setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }
}