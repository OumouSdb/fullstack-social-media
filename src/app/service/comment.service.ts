import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Comment } from '../Interfaces/Comment';
import { Observable } from 'rxjs';
import { Article } from '../Interfaces/Article';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) { }

  // getCommentById(articleId: string | undefined): Observable<Comment[]> {
  //   return this.http.get<Comment[]>(`${this.apiUrl}/comment/${articleId}`);
  // }

  getCommentsByArticleId(articleId: number): Observable<Comment[]> {
    return this.http.get<Comment[]>(`${this.apiUrl}/comment/article/${articleId}`);
  }


  saveComment(comment: Partial<Comment>): Observable<Comment> {
    return this.http.post<Comment>(`${this.apiUrl}/comment/save`, comment)
  }
}
