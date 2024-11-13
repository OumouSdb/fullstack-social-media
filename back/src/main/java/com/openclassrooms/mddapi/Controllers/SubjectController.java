package com.openclassrooms.mddapi.Controllers;

import com.openclassrooms.mddapi.Dto.ArticleDto;
import com.openclassrooms.mddapi.Dto.SubjectDto;
import com.openclassrooms.mddapi.Models.Article;
import com.openclassrooms.mddapi.Models.Subject;
import com.openclassrooms.mddapi.Repositories.ArticleRepository;
import com.openclassrooms.mddapi.Services.ArticleService;
import com.openclassrooms.mddapi.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

   @Autowired
    private ArticleRepository articleRepository;

    @PostMapping("/save")
    public SubjectDto createArticle(SubjectDto subject){
       return this.subjectService.saveSubject(subject);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        this.subjectService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<SubjectDto> findById(@PathVariable long id){
       return this.subjectService.findById(id);
    }

    @GetMapping()
    public List<SubjectDto> getAll(){
        return this.subjectService.getAll();
    }

   }

