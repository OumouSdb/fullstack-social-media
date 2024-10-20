package Services;

import Models.Subject;
import Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject saveSubject(Subject subject) {
        return this.subjectRepository.save(subject);
    }

    public Optional<Subject> findById(long id) {
        return this.subjectRepository.findById(id);
    }

    public void deleteById(long id) {
        this.subjectRepository.deleteById(id);
    }

    public List<Subject> getAll() {
        return this.subjectRepository.findAll();
    }
}
