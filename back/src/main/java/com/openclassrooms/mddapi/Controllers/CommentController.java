package com.openclassrooms.mddapi.Controllers;

import com.openclassrooms.mddapi.Dto.CommentsDto;
import com.openclassrooms.mddapi.Models.Comments;
import com.openclassrooms.mddapi.Services.CommentsService;
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
    public CommentsDto createComment(@RequestBody CommentsDto comment) {
        return this.commentService.saveComment(comment);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        this.commentService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<CommentsDto> findById(@PathVariable long id) {
        return this.commentService.findById(id);
    }

    @GetMapping("/")
    public List<CommentsDto> getAll() {
        return this.commentService.getAll();
    }
}
