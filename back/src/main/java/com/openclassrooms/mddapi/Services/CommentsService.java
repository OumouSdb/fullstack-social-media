package com.openclassrooms.mddapi.Services;

import com.openclassrooms.mddapi.Dto.CommentsDto;
import com.openclassrooms.mddapi.Models.Comments;
import com.openclassrooms.mddapi.Repositories.CommentsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentsService {

  @Autowired
  private CommentsRepository commentsRepository;

  @Autowired
  private ModelMapper modelMapper;

  // Méthode pour convertir un Comment en CommentDto
  private CommentsDto convertToDto(Comments comments) {
    return modelMapper.map(comments, CommentsDto.class);
  }

  // Méthode pour convertir un CommentDto en Comment
  private Comments convertToEntity(CommentsDto commentsDto) {
    return modelMapper.map(commentsDto, Comments.class);
  }

  public CommentsDto saveComment(CommentsDto commentsDto) {
    Comments comments = convertToEntity(commentsDto);
    Comments savedComments = this.commentsRepository.save(comments);
    return convertToDto(savedComments);
  }

  public Optional<CommentsDto> findById(long id) {
    Optional<Comments> comments = this.commentsRepository.findById(id);
    return comments.map(this::convertToDto);
  }

  public void deleteById(long id) {
    this.commentsRepository.deleteById(id);
  }

  public List<CommentsDto> getAll() {
    List<Comments> commentsList = this.commentsRepository.findAll();
    return commentsList.stream()
      .map(this::convertToDto)
      .collect(Collectors.toList());
  }
}
