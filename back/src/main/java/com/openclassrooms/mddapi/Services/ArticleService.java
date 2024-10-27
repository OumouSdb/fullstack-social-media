package com.openclassrooms.mddapi.Services;

import com.openclassrooms.mddapi.Dto.ArticleDto;
import com.openclassrooms.mddapi.Models.Article;
import com.openclassrooms.mddapi.Repositories.ArticleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

  @Autowired
  private ArticleRepository articleRepository;

  @Autowired
  private ModelMapper modelMapper;

  public ArticleService() {
  }

  // Méthode pour convertir un Article en ArticleDto
  private ArticleDto convertToDto(Article article) {
    return modelMapper.map(article, ArticleDto.class);
  }

  // Méthode pour convertir un ArticleDto en Article
  private Article convertToEntity(ArticleDto articleDto) {
    return modelMapper.map(articleDto, Article.class);
  }

  public ArticleDto saveArticle(ArticleDto articleDto) {
    Article article = convertToEntity(articleDto);
    Article savedArticle = this.articleRepository.save(article);
    return convertToDto(savedArticle);
  }

  public Optional<ArticleDto> findById(long id) {
    Optional<Article> article = this.articleRepository.findById(id);
    return article.map(this::convertToDto);
  }

  public void deleteById(long id) {
    this.articleRepository.deleteById(id);
  }

  public List<ArticleDto> getAll() {
    List<Article> articles = this.articleRepository.findAll();
    return articles.stream()
      .map(this::convertToDto)
      .collect(Collectors.toList());
  }
}
