import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Article } from 'src/app/Interfaces/Article';
import { Comment } from 'src/app/Interfaces/Comment';
import { LoginResponse } from 'src/app/Interfaces/loginResponse';
import { ArticleService } from 'src/app/service/article-service';
import { CommentService } from 'src/app/service/comment.service';
import { LoginService } from 'src/app/service/login.service';

@Component({
    selector: 'app-article-detail',
    templateUrl: './article-detail.component.html',
    styleUrls: ['./article-detail.component.scss']
})
export class ArticleDetailComponent implements OnInit {

    article: Article | undefined;
    paramId: any | undefined;
    comments: Comment[] = [];
    form!: FormGroup;
    currentUser!: LoginResponse;

    constructor(
        private articlesService: ArticleService,
        private route: ActivatedRoute,
        private commentService: CommentService,
        private fb: FormBuilder,
        private loginService: LoginService
    ) { }

    ngOnInit(): void {
        this.paramId = this.route.snapshot.paramMap.get('id');

        if (this.paramId) {
            this.articlesService.getArticleById(this.paramId).subscribe(value => {
                this.article = value;

                this.commentService.getCommentsByArticleId(this.paramId).subscribe(value => {

                    this.comments = value;

                })
            });

        }

        this.loginService.me().subscribe(user => {
            this.currentUser = user;
            this.form.patchValue({ user: this.currentUser.id });
        });

        this.form = this.fb.group({
            content: ['', Validators.required],
            date: [new Date()],
            user: [null],
        });
    }

    back() {
        return window.history.back();
    }

    send() {
        if (this.form?.valid && this.currentUser && this.article) {
            console.log('Valeurs du formulaire:', this.form.get('content')?.value);

            const commentData: Comment = {
                content: this.form.get('content')?.value,
                user: { id: this.currentUser.id, firstname: this.currentUser.firstname, lastname: this.currentUser.lastname },
                article: { id: this.article.id },
            };

            this.commentService.saveComment(commentData).subscribe(value => {

                this.comments.push(value);
                this.form.reset();
            });
        }
    }



}
