import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginResponse } from 'src/app/Interfaces/loginResponse';
import { Subject } from 'src/app/Interfaces/Subject';
import { ArticleService } from 'src/app/service/article-service';
import { LoginService } from 'src/app/service/login.service';
import { ThemeService } from 'src/app/service/theme.service';

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.scss']
})
export class CreateArticleComponent implements OnInit {
  form!: FormGroup;
  subjects: Subject[] = [];
  currentUser!: LoginResponse;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private articleService: ArticleService,
    private subjectService: ThemeService,
    private userService: LoginService
  ) { }

  ngOnInit(): void {
    // Récupération de l'utilisateur actuel
    this.userService.me().subscribe(value => {
      this.currentUser = value;

      // Initialisation du formulaire après la récupération de l'utilisateur
      this.form = this.fb.group({
        subject: ['', Validators.required],
        title: ['', Validators.required],
        content: ['', Validators.required],
        date: [new Date()],
        user: [this.currentUser ? this.currentUser.id : null], // Vérifiez que `currentUser` est bien défini
      });
    });

    // Récupération des sujets
    this.subjectService.getSubjects().subscribe(value => {
      this.subjects = value;
    });
  }

  onSubmit() {
    if (this.form?.valid) {
      const articleData = {
        ...this.form.value,
        user: { id: this.currentUser.id }, // Mappage de l'utilisateur dans l'objet attendu
        subject: { id: this.form.value.subject }, // Mappage du sujet dans l'objet attendu
      };

      this.articleService.createArticle(articleData).subscribe(() => {
        this.router.navigate(['/articles']);
      });
    }
  }
}
