import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Article } from '../Interfaces/Article';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  private apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) { }


  getArticles(): Observable<Article[]> {
    return this.http.get<Article[]>(`${this.apiUrl}/article`);
  }

}