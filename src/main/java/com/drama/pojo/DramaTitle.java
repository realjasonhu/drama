package com.drama.pojo;

import java.util.Date;

public class DramaTitle {

    private Long id;

    private Date createTime;

    private String setIp;

    private String level;

    private String name;

    private Long infoId;

    public Long getId() {
        return id;
    }

    public DramaTitle setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public DramaTitle setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getSetIp() {
        return setIp;
    }

    public DramaTitle setSetIp(String setIp) {
        this.setIp = setIp == null ? null : setIp.trim();
        return this;
    }

    public String getLevel() {
        return level;
    }

    public DramaTitle setLevel(String level) {
        this.level = level == null ? null : level.trim();
        return this;
    }

    public String getName() {
        return name;
    }

    public DramaTitle setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public Long getInfoId() {
        return infoId;
    }

    public DramaTitle setInfoId(Long infoId) {
        this.infoId = infoId;
        return this;
    }
}