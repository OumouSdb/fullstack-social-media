package Controllers;

import Models.Comments;
import Services.CommentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/comment")
public class CommentController {

    private final CommentsService commentService;

    public CommentController(CommentsService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/save")
    public Comments createComment(@RequestBody Comments comment) {
        return this.commentService.saveComment(comment);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        this.commentService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Comments> findById(@PathVariable long id) {
        return this.commentService.findById(id);
    }

    @GetMapping()
    public List<Comments> getAll() {
        return this.commentService.getAll();
    }
}
