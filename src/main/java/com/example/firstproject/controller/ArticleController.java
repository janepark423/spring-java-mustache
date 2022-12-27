package com.example.firstproject.controller;


import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired  //TODO: 스프링부트가 미리 생성해놓은 객체를 가져다가 자동(DI: 의존성 주입) 으로 연결(인터페이스)
    private ArticleRepository articleRepository;
    //TODO:  Autowired : 어딘가에 만들어진 객체를 가져와서 크로스 매칭 후 SAVE 시켜줌

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        System.out.println(form.toString());
        
        //TODO: 1. Dto를 변환! Entity로
        Article article = form.toEntity();
        System.out.println(article.toString());
        //TODO: 2. DB에 저장 Repository에게 entity를 db안에 저장함
        //TODO: Repository가 DB에 저장하는 기능을 함.
        Article saved = articleRepository.save(article);
        //FIXME: articleRepository를 saved로 반환해준다.
        System.out.println(saved.toString());
        return "";
    }
}
