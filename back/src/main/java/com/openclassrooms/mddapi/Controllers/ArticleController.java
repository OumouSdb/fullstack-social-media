package com.openclassrooms.mddapi.Controllers;

import com.openclassrooms.mddapi.Dto.ArticleDto;
import com.openclassrooms.mddapi.Models.Article;
import com.openclassrooms.mddapi.Repositories.ArticleRepository;
import com.openclassrooms.mddapi.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

   @Autowired
    private ArticleRepository articleRepository;

  @PostMapping("/save")
  public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleDto article) {
    System.out.println("Received article: " + article);
    ArticleDto savedArticle = articleService.saveArticle(article);
    return ResponseEntity.ok(savedArticle);
  }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        this.articleService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<ArticleDto> findById(@PathVariable long id){
       return this.articleService.findById(id);
    }

    /*@GetMapping()
    public List<Article> getAll(){
        return this.articleService.getAll();
    }*/

  @GetMapping(value="")
  public List<Article> getAll(){
    return this.articleRepository.findAll();
  }
}
