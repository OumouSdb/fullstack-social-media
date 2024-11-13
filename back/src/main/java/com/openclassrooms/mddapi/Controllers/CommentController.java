package com.openclassrooms.mddapi.Controllers;

import com.openclassrooms.mddapi.Dto.CommentsDto;
import com.openclassrooms.mddapi.Models.Comments;
import com.openclassrooms.mddapi.Services.CommentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentsService commentService;

    public CommentController(CommentsService commentService) {
        this.commentService = commentService;
    }

  @PostMapping("/save")
  public ResponseEntity<CommentsDto> createComment(@RequestBody CommentsDto comment) {
    try {
      CommentsDto savedComment = this.commentService.saveComment(comment);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedComment); // 201 Created avec le commentaire sauvegardé
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // 400 Bad Request en cas d'erreur
    }
  }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        this.commentService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<CommentsDto> findById(@PathVariable long id) {
        return this.commentService.findById(id);
    }

  @GetMapping("/article/{articleId}")
  public List<Comments> getCommentsByArticleId(@PathVariable Long articleId) {
    return commentService.getCommentsByArticleId(articleId);
  }

    @GetMapping("/")
    public List<CommentsDto> getAll() {
        return this.commentService.getAll();
    }
}
