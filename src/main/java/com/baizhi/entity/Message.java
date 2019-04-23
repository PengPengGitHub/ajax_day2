package com.baizhi.entity;

import java.util.Date;

public class Message {

    private String id;
    private String content;
    private Date createDate;
    private Integer counts;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", counts=" + counts +
                '}';
    }

    public Message() {
    }

    public Message(String id, String content, Date createDate, Integer counts) {
        this.id = id;
        this.content = content;
        this.createDate = createDate;
        this.counts = counts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }
}
