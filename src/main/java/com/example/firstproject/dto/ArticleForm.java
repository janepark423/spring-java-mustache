package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;

public class ArticleForm {

    private String title;
    private String content;

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Article toEntity() {
        //TODO: 엔티티 Article 객체를 반환해줌
        return new Article(null, title, content);
    }
}
