package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor //생성자와 똑같은 역할
@ToString //ToString과 똑같은 역할
public class ArticleForm {

    

    private String title;
    private String content;


    public Article toEntity() {
        //TODO: 엔티티 Article 객체를 반환해줌
        return new Article(null, title, content);
    }
}
