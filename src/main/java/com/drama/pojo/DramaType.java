package com.drama.pojo;

public class DramaType {
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public DramaType setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DramaType setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }
}