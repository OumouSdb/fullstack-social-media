package com.openclassrooms.mddapi.Services;

import com.openclassrooms.mddapi.Dto.SubjectDto;
import com.openclassrooms.mddapi.Models.Subject;
import com.openclassrooms.mddapi.Repositories.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService {

  @Autowired
  private SubjectRepository subjectRepository;

  @Autowired
  private ModelMapper modelMapper;

  // Méthode pour convertir un Subject en SubjectDto
  private SubjectDto convertToDto(Subject subject) {
    return modelMapper.map(subject, SubjectDto.class);
  }

  // Méthode pour convertir un SubjectDto en Subject
  private Subject convertToEntity(SubjectDto subjectDto) {
    return modelMapper.map(subjectDto, Subject.class);
  }

  public SubjectDto saveSubject(SubjectDto subjectDto) {
    Subject subject = convertToEntity(subjectDto);
    Subject savedSubject = this.subjectRepository.save(subject);
    return convertToDto(savedSubject);
  }

  public Optional<SubjectDto> findById(long id) {
    Optional<Subject> subject = this.subjectRepository.findById(id);
    return subject.map(this::convertToDto);
  }

  public void deleteById(long id) {
    this.subjectRepository.deleteById(id);
  }

  public List<SubjectDto> getAll() {
    List<Subject> subjects = this.subjectRepository.findAll();
    return subjects.stream()
      .map(this::convertToDto)
      .collect(Collectors.toList());
  }
}
