package com.global.core.bean;

public class TaskList {
    private String id;
    private String label;
    private String user_fk;

    public TaskList() {
    }

    public TaskList(String id, String label, String user_fk) {
        this.id = id;
        this.label = label;
        this.user_fk = user_fk;
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

    public String getUser_fk() {
        return user_fk;
    }

    public void setUser_fk(String user_fk) {
        this.user_fk = user_fk;
    }
}
