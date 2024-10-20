package Controllers;

import Models.Article;
import Services.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/article")
public class ArticleController {

    private ArticleService articleService;

    @PostMapping("/save")
    public Article createArticle(Article article){
       return this.articleService.saveArticle(article);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        this.articleService.deleteById(id);
    }

    @GetMapping("/{}")
    public Optional<Article> findById(@PathVariable long id){
       return this.articleService.findById(id);
    }

    @GetMapping()
    public List<Article> getAll(){
        return this.articleService.getAll();
    }
}
