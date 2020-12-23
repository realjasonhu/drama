package com.drama.pojo;

import java.io.Serializable;
import java.util.Date;

public class DramaInfo implements Serializable {

    private Long id;

    private Date createTime;

    private String setIp;

    private Date updateTime;

    private String updateIp;

    private String title;

    private String subTitle;

    private Long menuId;

    private String isHot;

    private String number;

    private String typeName;

    private String duration;

    private String price;

    private String description;

    private String articleUrl;

    private String pictureUrl;

    private String playStatus;

    public String getPlayStatus() {
        return playStatus;
    }

    public DramaInfo setPlayStatus(String playStatus) {
        this.playStatus = playStatus;
        return this;
    }

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

    public Date getUpdateTime() {
        return updateTime;
    }

    public DramaInfo setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getUpdateIp() {
        return updateIp;
    }

    public DramaInfo setUpdateIp(String updateIp) {
        this.updateIp = updateIp == null ? null : updateIp.trim();
        return this;
    }

    public String getIsHot() {
        return isHot;
    }

    public DramaInfo setIsHot(String isHot) {
        this.isHot = isHot == null ? null : isHot.trim();
        return this;
    }

    public String getNumber() {
        return number;
    }

    public DramaInfo setNumber(String number) {
        this.number = number == null ? null : number.trim();
        return this;
    }

    public String getTypeName() {
        return typeName;
    }

    public DramaInfo setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public DramaInfo setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
        return this;
    }

    public String getPrice() {
        return price;
    }

    public DramaInfo setPrice(String price) {
        this.price = price == null ? null : price.trim();
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DramaInfo setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public DramaInfo setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl == null ? null : articleUrl.trim();
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public DramaInfo setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}