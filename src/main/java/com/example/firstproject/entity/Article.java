package com.example.firstproject.entity;


import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity  //TODO: DB가 해당 객체를 인식 가능!
@AllArgsConstructor //TODO:id, title, content에 해당하는 생성자를 저 넘이 생성해줌
@ToString //TODO: TOSTRING
public class Article {

    @Id //TODO: DB가 이해할 수 있는 값이 되도록, 대표값을 지정
    @GeneratedValue //1,2,3, 자동 생성 어노테이션
    private Long id;
    
    @Column
    private String title;

    @Column
    private String content;

//    @Override
//    public String toString() {
//        return "Article{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }

    //TODO: 생성자
//    public Article(Long id, String title, String content) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }
}
