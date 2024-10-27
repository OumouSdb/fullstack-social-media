package com.openclassrooms.mddapi.Controllers;

import com.openclassrooms.mddapi.Dto.ArticleDto;
import com.openclassrooms.mddapi.Models.Article;
import com.openclassrooms.mddapi.Repositories.ArticleRepository;
import com.openclassrooms.mddapi.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

   @Autowired
    private ArticleRepository articleRepository;

    @PostMapping("/save")
    public ArticleDto createArticle(ArticleDto article){
       return this.articleService.saveArticle(article);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        this.articleService.deleteById(id);
    }

    @GetMapping("article/{id}")
    public Optional<ArticleDto> findById(@PathVariable long id){
       return this.articleService.findById(id);
    }

    /*@GetMapping()
    public List<Article> getAll(){
        return this.articleService.getAll();
    }*/

  @GetMapping(value="/article")
  public List<Article> getAll(){
    return this.articleRepository.findAll();
  }
}
