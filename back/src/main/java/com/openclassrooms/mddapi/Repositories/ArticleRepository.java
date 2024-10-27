package com.openclassrooms.mddapi.Repositories;

import com.openclassrooms.mddapi.Models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
