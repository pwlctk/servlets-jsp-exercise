package com.example.mvc.model;

import java.time.LocalDateTime;

public class Post {
    private Long id;
    private String subject;
    private String content;
    private LocalDateTime creationDate;
    private User creator;

    public Post() {
    }

    public Post(Long id, String subject, String content, User creator) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.creationDate = LocalDateTime.now();
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
