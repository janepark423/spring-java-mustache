package com.example.firstproject.controller;


import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j //로깅을 위한 골뱅이 sout 대신의 역할을 함
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
        
        //TODO: SOUT을 LOGGING으로 대체하자
        //System.out.println(form.toString());
        log.info(form.toString());
        
        //TODO: 1. Dto를 변환! Entity로
        Article article = form.toEntity();

        log.info(article.toString());
       // System.out.println(article.toString());
        //TODO: 2. DB에 저장 Repository에게 entity를 db안에 저장함
        //TODO: Repository가 DB에 저장하는 기능을 함.
        Article saved = articleRepository.save(article);
        //FIXME: articleRepository를 saved로 반환해준다.
        log.info(saved.toString());
        //System.out.println(saved.toString());
        return "";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable  Long id, Model model){
        log.info("id = " + id);


        //TODO: 1번  ID로 데이터를 가져옴(리파지토리에서 가져옴)
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //FIXME: ID값이나 DATA가 없을 경우 예외처리




        //TODO: 2번 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);



        //TODO: 3번  보여줄 페이지를 설정!
        return "articles/show";
    }

    public String index(){
        return "";
    }
}
