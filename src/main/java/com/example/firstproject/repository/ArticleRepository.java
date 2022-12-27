package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    //TODO: CrudRepository 를 상속받는다(JPA 기능)
    //TODO: < >에는 <관리대상인자, 관리대상의 대표값 타입>

    @Override
    ArrayList<Article> findAll();
}
