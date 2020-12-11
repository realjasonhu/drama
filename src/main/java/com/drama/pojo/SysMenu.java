package com.drama.pojo;

import java.util.Date;

public class SysMenu {
    private Long id;

    private Date createTime;

    private String setIp;

    private String level;

    private String name;

    public Long getId() {
        return id;
    }

    public SysMenu setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public SysMenu setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getSetIp() {
        return setIp;
    }

    public SysMenu setSetIp(String setIp) {
        this.setIp = setIp == null ? null : setIp.trim();
        return this;
    }

    public String getLevel() {
        return level;
    }

    public SysMenu setLevel(String level) {
        this.level = level == null ? null : level.trim();
        return this;
    }

    public String getName() {
        return name;
    }

    public SysMenu setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }
}