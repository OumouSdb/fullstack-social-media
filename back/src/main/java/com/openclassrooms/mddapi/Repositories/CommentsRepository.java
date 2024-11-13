package com.openclassrooms.mddapi.Repositories;

import com.openclassrooms.mddapi.Models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {

  List<Comments> findByArticleId(Long articleId);
}
