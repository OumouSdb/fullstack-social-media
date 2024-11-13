import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { from, Observable, of, reduce } from 'rxjs';
import { Article } from 'src/app/Interfaces/Article';
import { ArticleService } from 'src/app/service/article-service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.scss']
})
export class ArticlesComponent implements OnInit {
  articles: Article[] = [];
  sortArray: Observable<string[]> = of(["recent", "old", "title", "author"]);
  constructor(private articlesService: ArticleService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    if (!sessionStorage.getItem('reloaded')) {
      // Marquer le rechargement comme effectué dans cette session
      sessionStorage.setItem('reloaded', 'true');
      // Recharger la page
      window.location.reload();
    } else {
      // Charger les articles après rechargement
      this.articlesService.getArticles().subscribe(value => {
        this.articles = value;
      });
    }

  }

  sortArticles(event: Event) {
    const criterion = (event.target as HTMLSelectElement).value;

    if (!criterion) {
      return;
    }

    switch (criterion) {
      case "recent":
        this.articles.sort((a, b) => new Date(b.date).getTime() - new Date(a.date).getTime());
        break;
      case "old":
        this.articles.sort((a, b) => new Date(a.date).getTime() - new Date(b.date).getTime());
        break;
      case "title":
        this.articles.sort((a, b) => a.title.localeCompare(b.title));
        break;
      default:
    }
  }


}
