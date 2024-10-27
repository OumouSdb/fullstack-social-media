import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from 'src/app/Interfaces/Article';
import { ArticleService } from 'src/app/service/article-service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.scss']
})
export class ArticlesComponent implements OnInit {
  articles: Article[] = [];
  constructor(private articlesService: ArticleService) { }

  ngOnInit(): void {

    this.articlesService.getArticles().pipe().subscribe(value => {
      this.articles = value;

      console.log(this.articles);

    })
  }

}
