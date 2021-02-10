package com.global.core.bean;

public class Task {
    private String id;
    private String label;
    private String list_fk;

    public Task() {
    }

    public Task(String id, String label, String list_fk) {
        this.id = id;
        this.label = label;
        this.list_fk = list_fk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getList_fk() {
        return list_fk;
    }

    public void setList_fk(String list_fk) {
        this.list_fk = list_fk;
    }
}
