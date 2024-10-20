package Services;

import Models.Comments;
import Repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentRepository;

    public Comments saveComment(Comments comment) {
        return this.commentRepository.save(comment);
    }

    public Optional<Comments> findById(long id) {
        return this.commentRepository.findById(id);
    }

    public void deleteById(long id) {
        this.commentRepository.deleteById(id);
    }

    public List<Comments> getAll() {
        return this.commentRepository.findAll();
    }
}
