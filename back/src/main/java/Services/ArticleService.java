package Services;

import Models.Article;
import Repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRespository;

    public Article saveArticle(Article article){
        return this.articleRespository.save(article);
    }

    public Optional<Article> findById(long id){
        Optional<Article> article = null;
        if(article.isPresent()){
            return this.articleRespository.findById(id);
        }
        return null;
    }

    public void deleteById(long id){
    this.articleRespository.deleteById(id);
    }

    public List<Article> getAll(){
        return this.articleRespository.findAll();
    }

}
